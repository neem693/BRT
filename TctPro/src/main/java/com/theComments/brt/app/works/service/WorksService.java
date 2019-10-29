package com.theComments.brt.app.works.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theComments.brt.app.common.CommonSecure;
import com.theComments.brt.app.common.FileManager;
import com.theComments.brt.constFile.FileConst;
import com.theComments.brt.constFile.PageConst;
import com.theComments.brt.jpa.dto.ArtistDto;
import com.theComments.brt.jpa.dto.SimpleUserDto;
import com.theComments.brt.jpa.dto.WorksDto;
import com.theComments.brt.jpa.theComment.dao.Artist_dao;
import com.theComments.brt.jpa.theComment.dao.Create_art_dao;
import com.theComments.brt.jpa.theComment.dao.Eva_user_dao;
import com.theComments.brt.jpa.theComment.dao.FileSave_dao;
import com.theComments.brt.jpa.theComment.dao.Type2_dao;
import com.theComments.brt.jpa.theComment.dao.WorksSave_dao;
import com.theComments.brt.jpa.theComment.dao.Works_dao;
import com.theComments.brt.jpa.theComment.model.Artist;
import com.theComments.brt.jpa.theComment.model.Create_art;
import com.theComments.brt.jpa.theComment.model.Eva_user;
import com.theComments.brt.jpa.theComment.model.FileSave;
import com.theComments.brt.jpa.theComment.model.Type2;
import com.theComments.brt.jpa.theComment.model.Works;
import com.theComments.brt.jpa.theComment.model.WorksSave;
import com.theComments.brt.util.ResultMap;

@Service
public class WorksService {

	@Autowired
	Eva_user_dao evaUserDao;

	@Autowired
	Works_dao worksDao;

	@Autowired
	Type2_dao tpye2Dao;

	@Autowired
	FileSave_dao fileDao;

	@Autowired
	WorksSave_dao worksSaveDao;
	
	@Autowired
	Artist_dao artistDao;
	
	@Autowired
	Create_art_dao createArtDao;

	@Autowired
	HttpServletRequest request;

	/**
	 * 저작물을 저장하는 서비스
	 * 
	 * @param f
	 * @param data
	 * @return Map 200일 경우 정상, 201일경우 저장은 했으나, 저작자가 존재하지 않음. id라는 key가 있음. 해당 id는
	 *         works 에 등록된 id
	 * @throws Exception
	 *             파일 문제,403005:파일이 4개이상
	 *             403006:이미 저작자와 저작물이 엮여있음
	 */
	@Transactional("userTransactionManager")
	public ResultMap saveWorks(MultipartFile[] f, Map<String, Object> data) throws Exception {

		ResultMap result = new ResultMap();
		result.setResult(200);

		long type2Id = new Long(data.get("type2").toString());
		Optional<Type2> type2 = tpye2Dao.findById(type2Id);

		long create_date_unix = Long.parseLong(data.get("create_date").toString());
		LocalDateTime create_date_time = CommonSecure.getDateTime(create_date_unix);

		LocalDateTime create_end_date = null;

		boolean is_series = new Boolean(data.get("is_series").toString());
		int is_series_data = 0;
		
		ObjectMapper mapper = new ObjectMapper();
		String artistListStr =  data.get("artistList").toString();
		List<Map<String,Object>> artistList = (List<Map<String,Object>>)mapper.readValue(artistListStr, List.class);
		

		if (is_series == true) {
			is_series_data = 1;
			try {
				long create_end_date_unix = Long.parseLong(data.get("create_end_date").toString());
				create_end_date = CommonSecure.getDateTime(create_end_date_unix);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				create_end_date = null;
			}

		}

		Works works = new Works();
		works.setSubject(data.get("subject").toString());
		works.setType2(type2.get());
		works.setCreate_date(create_date_time);
		works.setCreate_end_date2(create_end_date);
		works.setIs_series(is_series_data);
		Works savedWorks = worksDao.save(works);
		result.setId(savedWorks.getWork_id());
		// 저작물 저장 끝 ////////////////////////////////////

		List<FileSave> fileSaveArray = new ArrayList<FileSave>();

		if (f.length > 4) {
			throw new RuntimeException("403005:파일 4개이상");
		}

		for (MultipartFile mf : f) {

			FileSave item = FileManager.fileSave(mf, FileConst.UPLOAD_CONST.WORK_IMAGE_BASE_PATH, "jpeg|jpg|gif|png");

			item.setWorks(works);
			fileSaveArray.add(item);

		}
		if (fileSaveArray.size() > 0) {
			fileSaveArray = fileDao.saveAll(fileSaveArray);
		}
		// 저작물 이미지 저장 끝////////////////////

		SimpleUserDto userDto = CommonSecure.getSimpleUserDto(request);

		Optional<Eva_user> me = evaUserDao.findById(userDto.getUserId());

		WorksSave worksSave = new WorksSave();
		worksSave.setEva_user(me.get());
		worksSave.setWorks(savedWorks);
		worksSaveDao.save(worksSave);
		// 유저 저작물 저장에 대한 정보 저장 끝///////////

		
		if (artistList.size() == 0) {
			result.setResult(201);
		} else {
			for (Map<String, Object> artist : artistList) {
				Long id = Long.parseLong(artist.get("artist_id").toString());
				
				List<Create_art> create_list =createArtDao.findArtistAndWorks(id,savedWorks.getWork_id());
				if(create_list.size() >0) {
					throw new RuntimeException("403006:이미 저작자와 저작물이 엮여있음");
				}
				
				Optional<Artist> artistModel = artistDao.findById(id);
				Create_art create_art = new Create_art();
				create_art.setArtist(artistModel.get());
				create_art.setWorks(savedWorks);
				create_art.setSave_date(LocalDateTime.now());
				createArtDao.save(create_art);
				
			}
		}
		//저작물과 저작자 엮음 끝
		
		return result;
	}

	/**
	 * id로 저작물 셀렉트
	 * 
	 * @param param
	 * @return result 200 저작물 저작자 모두 있음 201 저작물 존재 하지 않음, 202 저작자 존재하지 않음
	 */
	public ResultMap worksSelectOne(Map<String, Object> param) {
		// TODO Auto-generated method stub
		ResultMap result = new ResultMap();

		Long id = Long.parseLong(param.get("id").toString());

		Optional<Works> workM = worksDao.findById(id);
		if (workM.isPresent() == false) {
			result.setResult(201);
			return result;
		}

		Works work = workM.get();

		WorksDto worksDto = new WorksDto();

		BeanUtils.copyProperties(work, worksDto);
		List<Create_art> create_list = work.getCreate();
		if (create_list.size() == 0) {
			result.setResult(202);
			result.setData(worksDto);
			return result;
		}
		// 200인건 아티스트 삽입하고 만들기
		
		Artist artist = create_list.get(create_list.size()-1).getArtist();
		ArtistDto artistDto = new ArtistDto();
		BeanUtils.copyProperties(artist, artistDto);
		
		Map<String,Object> data = new HashMap<>();
		data.put("works", worksDto);
		data.put("artist", artistDto);
		
		result.setResult(200);
		result.setData(data);

		return result;
	}

	/**
	 * 페이지네이션 처리한 저작물에 대한 검색
	 * 
	 * @param worksDto
	 *            제목
	 * @return
	 */
	public ResultMap selectWorks(WorksDto worksDto) {
		// TODO Auto-generated method stub

		ResultMap result = new ResultMap();

		int pageNum = worksDto.getPageNum() - 1;
		int pageSize = PageConst.PAGE.PAGE_SIZE;

		Pageable pageable = PageRequest.of(pageNum, pageSize);
		String subject = worksDto.getSearchText() == null ? "" : worksDto.getSearchText();
		Page<Works> pageList = worksDao.selectWorks(subject, pageable);

		List<Works> list = pageList.getContent();
		List<WorksDto> listDto = new ArrayList<WorksDto>();
		for (Works work : list) {
			WorksDto dto = new WorksDto();

			BeanUtils.copyProperties(work, dto);

			listDto.add(dto);

		}

		result.setData(listDto);
		result.setResult(200);
		result.setTotalSize(pageList.getTotalElements());

		return result;
	}

}
