package com.theComments.brt.app.works.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.theComments.brt.app.common.CommonSecure;
import com.theComments.brt.app.common.FileManager;
import com.theComments.brt.constFile.FileConst;
import com.theComments.brt.jpa.dto.SimpleUserDto;
import com.theComments.brt.jpa.theComment.dao.Eva_user_dao;
import com.theComments.brt.jpa.theComment.dao.FileSave_dao;
import com.theComments.brt.jpa.theComment.dao.Type2_dao;
import com.theComments.brt.jpa.theComment.dao.WorksSave_dao;
import com.theComments.brt.jpa.theComment.dao.Works_dao;
import com.theComments.brt.jpa.theComment.model.Eva_user;
import com.theComments.brt.jpa.theComment.model.FileSave;
import com.theComments.brt.jpa.theComment.model.Type2;
import com.theComments.brt.jpa.theComment.model.Works;
import com.theComments.brt.jpa.theComment.model.WorksSave;

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
	HttpServletRequest request;

	/**
	 * 
	 * @param f
	 * @param data
	 * @return
	 * @throws Exception 파일 문제,403005:파일이 4개이상
	 */
	@Transactional("userTransactionManager")
	public int saveWorks(MultipartFile[] f, Map<String, Object> data) throws Exception {

		long type2Id = new Long(data.get("type2").toString());
		Optional<Type2> type2 = tpye2Dao.findById(type2Id);

		long create_date_unix = Long.parseLong(data.get("create_date").toString());
		LocalDateTime create_date_time = CommonSecure.getDateTime(create_date_unix);

		LocalDateTime create_end_date = null;

		boolean is_series = new Boolean(data.get("is_series").toString());
		int is_series_data = 0;

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
		//저작물 저장 끝 ////////////////////////////////////
		
		List<FileSave> fileSaveArray = new ArrayList<FileSave>();
		
		if(f.length > 4) {
			throw new RuntimeException("403005:파일 4개이상");
		}

		for (MultipartFile mf : f) {

		FileSave item =	FileManager.fileSave(
					mf,
					FileConst.UPLOAD_CONST.WORK_IMAGE_BASE_PATH,
					"jpeg|jpg|gif|png"
					);
			
			item.setWorks(works);
			fileSaveArray.add(item);

		}
		if(fileSaveArray.size()>0) {
			fileSaveArray = fileDao.saveAll(fileSaveArray);
		}
		//저작물 이미지 저장 끝////////////////////
		
		SimpleUserDto userDto = CommonSecure.getSimpleUserDto(request);
		
		Optional<Eva_user> me = evaUserDao.findById(userDto.getUserId());
		
		WorksSave worksSave = new WorksSave();
		worksSave.setEva_user(me.get());
		worksSave.setWorks(savedWorks);
		worksSaveDao.save(worksSave);
		//유저 저작물 저장에 대한 정보 저장 끝///////////
		
		return 200;
	}

}
