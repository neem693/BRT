package com.theComments.brt.app.artist.service;

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
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.theComments.brt.app.common.CommonSecure;
import com.theComments.brt.constFile.PageConst;
import com.theComments.brt.jpa.dto.ArtistDto;
import com.theComments.brt.jpa.dto.OrderForSearch;
import com.theComments.brt.jpa.dto.SimpleUserDto;
import com.theComments.brt.jpa.dto.Type1Dto;
import com.theComments.brt.jpa.dto.Type2Dto;
import com.theComments.brt.jpa.dto.WorksDto;
import com.theComments.brt.jpa.theComment.dao.ArtistDynamicQueryDao;
import com.theComments.brt.jpa.theComment.dao.ArtistSave_dao;
import com.theComments.brt.jpa.theComment.dao.Artist_dao;
import com.theComments.brt.jpa.theComment.dao.Create_art_dao;
import com.theComments.brt.jpa.theComment.dao.Eva_user_dao;
import com.theComments.brt.jpa.theComment.dao.Works_dao;
import com.theComments.brt.jpa.theComment.model.Artist;
import com.theComments.brt.jpa.theComment.model.ArtistSave;
import com.theComments.brt.jpa.theComment.model.Create_art;
import com.theComments.brt.jpa.theComment.model.Eva_user;
import com.theComments.brt.jpa.theComment.model.Works;
import com.theComments.brt.mapper.DynamicQueryByMybatis;
import com.theComments.brt.util.ResultMap;

@Service
public class ArtistService {

	@Autowired
	Artist_dao artistDao;

	@Autowired
	Eva_user_dao eva_userDao;

	@Autowired
	ArtistSave_dao artistSaveDao;

	@Autowired
	Works_dao worksDao;

	@Autowired
	Create_art_dao createArtDao;
	
	@Autowired
	ArtistDynamicQueryDao artistDynamicQueryDao;

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	DynamicQueryByMybatis mybatisDynamicQueryDao;

	/**
	 * 
	 * @param data
	 *            해당 데이터에는 artist_name 즉 저작자 이름이 있어야 한다. worksList 는 저작물에 대한 리스트를 담고
	 *            있음
	 * @return 200일 경우 전체가 다 입력됨, 201일 경우 저작물 저장이 안됨.
	 * @exception 501111:artist
	 *                name is null,
	 */
	@Transactional("userTransactionManager")
	public ResultMap artistSave(Map<String, Object> data) {
		// TODO Auto-generated method stub

		ResultMap result = new ResultMap();
		result.setResult(200);

		try {
			if (data.get("artist_name") == null) {
				throw new Exception("501111:artist name is null");
			}

			Artist artistModel = new Artist();
			artistModel.setAdd_date(LocalDateTime.now());
			artistModel.setArt_name(data.get("artist_name").toString());
			artistModel.setDelYn(0);
			
			artistModel = artistDao.save(artistModel);
			// 저작자 저장 끝//

			SimpleUserDto userDto = CommonSecure.getSimpleUserDto(request);

			Optional<Eva_user> user = eva_userDao.findById(userDto.getUserId());
			ArtistSave artistSave = new ArtistSave();
			artistSave.setArtist(artistModel);
			artistSave.setSave_date(LocalDateTime.now());
			artistSave.setEva_user(user.get());

			artistSave = artistSaveDao.save(artistSave);
			// 아티스트 저장에 대한 유저 저장 끝//
			List<Map<String, Object>> workslist = (List<Map<String, Object>>) data.get("worksList");
			if (workslist.size() > 0) {
				List<Create_art> createArtList = new ArrayList<Create_art>();
				for (Map<String, Object> mapWork : workslist) {

					Long work_id = Long.parseLong(mapWork.get("work_id").toString());
					Optional<Works> works = worksDao.findById(work_id);

					Create_art create_art = new Create_art();
					create_art.setArtist(artistModel);
					create_art.setWorks(works.get());
					create_art.setSave_date(LocalDateTime.now());
					createArtList.add(create_art);
				}
				createArtDao.saveAll(createArtList);
				result.setId(artistModel.getArtist_id());
				// 저작자와 저작물 이어주는 save 끝
			} else {

				// 저작물 없음
				result.setResult(201);
				result.setId(artistModel.getArtist_id());

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}

		return result;
	}

	/**
	 * 
	 * @param param
	 * @return 200 저작물 저작자 모두 있음 201 저작자 존재 하지 않음, 202 저작물 존재하지 않음
	 */
	public ResultMap artistSelectOne(Map<String, Object> param) {
		// TODO Auto-generated method stub

		ResultMap result = new ResultMap();
		Map<String, Object> data = new HashMap<String, Object>();

		Long id = Long.parseLong(param.get("id").toString());

		Artist artist = new Artist();
		artist.setArtist_id(id);

		Optional<Artist> artistData = artistDao.findById(id);
		if (artistData == null) {
			result.setResult(201);
			return result;
		}

		ArtistDto artistDto = new ArtistDto();
		BeanUtils.copyProperties(artistData.get(), artistDto);
		data.put("artistDto", artistDto);

		List<Create_art> create_art_list = artistData.get().getCreate();

		if (create_art_list.size() == 0) {
			result.setResult(202);
			result.setData(data);
			return result;
		}

		Create_art create = create_art_list.get(create_art_list.size() - 1);
		;
		Works work = create.getWorks();

		WorksDto worksDto = new WorksDto();
		BeanUtils.copyProperties(work, worksDto);

		data.put("worksDto", worksDto);

		result.setResult(200);
		result.setData(data);

		return result;
	}

	/**
	 * 아티스트 리스트 목록으로 가져오기
	 * @param artistDto
	 * @return
	 */
	public ResultMap selectArtistList(ArtistDto artistDto) {
		// TODO Auto-generated method stub

		int page = artistDto.getPageNum() - 1;
		int size = PageConst.PAGE.PAGE_SIZE;

		Pageable pageable = PageRequest.of(page, size);
		String art_name = artistDto.getSearchText() == null ? "" : artistDto.getSearchText() ;

		Page<Artist> artistListPage = artistDao.artistSelectList(art_name, pageable);

		List<Artist> artistList = artistListPage.getContent();
		List<ArtistDto> artistDtoList = new ArrayList<>();
		for (Artist artist : artistList) {
			ArtistDto dto = new ArtistDto();

			BeanUtils.copyProperties(artist, dto);

			artistDtoList.add(dto);
		}

		ResultMap result = new ResultMap();
		result.setData(artistDtoList);
		result.setTotalSize(artistListPage.getTotalElements());
		result.setResult(200);

		return result;
	}

	public ResultMap artistSearch(Long type1, Long type2, String searchText, Integer order, Integer order2,
			Integer pageNum) {
		// TODO Auto-generated method stub
		
//		int pageNum = Integer.parseInt(param.get("pageNum").toString());
//		int order = Integer.parseInt(param.get("order").toString());
//		int order2 = Integer.parseInt(param.get("order2").toString());
//		
//		Long type1 = Long.parseLong(param.get("type1").toString());
//		Long type2 = Long.parseLong(param.get("type2").toString());
//		
//		String searchText = "";
//		if(param.get("searchText") != null) {
//			searchText = param.get("searchText").toString();
//		}
		
		ArtistDto artistDto = new ArtistDto();
		artistDto.setSearchText(searchText);
		artistDto.setPageNum(pageNum);
		
		Type1Dto type1Dto = new Type1Dto();
		type1Dto.setType1_id(type1);
		
		Type2Dto type2Dto = new Type2Dto();
		type2Dto.setType2_id(type2);
		
		OrderForSearch orderForSearch = new OrderForSearch();
		orderForSearch.setOrder(order);
		orderForSearch.setOrder2(order2);
		
		String art_name = artistDto.getSearchText() == null ? "" : artistDto.getSearchText() ;
		
		
//		Pageable pageable = PageRequest.of(pageNum - 1, 10, JpaSort.unsafe(Sort.Direction.DESC,"(worksMax)").and(JpaSort.unsafe(Sort.Direction.DESC,"(count)")));
		Sort sort = Sort.unsorted();
		if(order == 0) {
			sort.and(JpaSort.unsafe(Sort.Direction.DESC,"MAX(w.create_date)"));
		}
		
		if(order == 1) {
			sort.and(JpaSort.unsafe(Sort.Direction.DESC,"COUNT(t1.type1_id)"));
		}
		
		Pageable pageable = PageRequest.of(pageNum - 1, 10, sort);
		
		if(type1 == 0) {
			type1 = null;
		}
		
		if(type2 == 0) {
			type2  = null;
		}
		
		Page<Map<String,Object>> pageArtist = artistDao.search(type1,type2,pageable);
		
		List<Map<String,Object>> artistList = pageArtist.getContent();
		
		Map<String,Object> returnData = artistDynamicQueryDao.searchArtistDynamic(artistDto,type1Dto,type2Dto,orderForSearch);
		
		ResultMap result = new ResultMap();
		result.setData(artistList);
		result.setTotalSize(pageArtist.getTotalElements());
		result.setResult(200);
		
//		List list = mybatisDynamicQueryDao.searchArtist();
//		System.out.println(list);
		
		return result;
	}
}
