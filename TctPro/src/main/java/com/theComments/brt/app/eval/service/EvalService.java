package com.theComments.brt.app.eval.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.bouncycastle.crypto.RuntimeCryptoException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Dynamic;
import com.theComments.brt.app.common.CommonSecure;
import com.theComments.brt.app.common.FileManager;
import com.theComments.brt.constFile.FileConst;
import com.theComments.brt.constFile.PageConst;
import com.theComments.brt.jpa.dto.ArtistDto;
import com.theComments.brt.jpa.dto.EvaluateDto;
import com.theComments.brt.jpa.dto.Evaluation_itemDto;
import com.theComments.brt.jpa.dto.FileSaveDto;
import com.theComments.brt.jpa.dto.OrderForSearch;
import com.theComments.brt.jpa.dto.SimpleUserDto;
import com.theComments.brt.jpa.dto.Type1Dto;
import com.theComments.brt.jpa.dto.Type2Dto;
import com.theComments.brt.jpa.dto.WorksDto;
import com.theComments.brt.jpa.theComment.dao.DynamicQueryDao;
import com.theComments.brt.jpa.theComment.dao.Eva_user_dao;
import com.theComments.brt.jpa.theComment.dao.EvalDynamicQueryDao;
import com.theComments.brt.jpa.theComment.dao.Evaluate_dao;
import com.theComments.brt.jpa.theComment.dao.Evaluation_item_dao;
import com.theComments.brt.jpa.theComment.dao.FileSave_dao;
import com.theComments.brt.jpa.theComment.dao.Works_dao;
import com.theComments.brt.jpa.theComment.model.Artist;
import com.theComments.brt.jpa.theComment.model.Create_art;
import com.theComments.brt.jpa.theComment.model.Eva_user;
import com.theComments.brt.jpa.theComment.model.Evaluate;
import com.theComments.brt.jpa.theComment.model.Evaluation_item;
import com.theComments.brt.jpa.theComment.model.FileSave;
import com.theComments.brt.jpa.theComment.model.Works;
import com.theComments.brt.util.ResultMap;

import sun.misc.BASE64Decoder;

@Service
public class EvalService {
	
	@Autowired
	Eva_user_dao eva_user_dao;
	
	@Autowired
	Works_dao works_dao;
	
	@Autowired
	Evaluation_item_dao eval_item_dao;
	
	@Autowired
	Evaluate_dao eval_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	EvalDynamicQueryDao evalDynamicQueryDao;
	
	@Autowired
	FileSave_dao fileSaveDao;

	/**
	 * 
	 * @param dto
	 * @return resultMap
	 * 200:work -> work, artist->artist,totalSize -> artist Size
	 * 201:no one work
	 * 202:no one artsit
	 * 
	 */
	public ResultMap getWork(WorksDto dto) {
		// TODO Auto-generated method stub
		
		ResultMap result = new ResultMap();
		Integer artistSize = 0;
		
		Optional<Works> works_optional =this.works_dao.findById(dto.getWork_id());
		if(works_optional.isPresent() == false) {
			result.setResult(201);
			return result;
		}
		Works work = works_optional.get();
		
		///////later you can change this select algorism for leader on of artists
		List<Create_art> create_art_list = new ArrayList<Create_art>();
		create_art_list.addAll(work.getCreate());
		
		if(create_art_list.size() == 0) {
			result.setResult(202);
			return result;
		}
		
		artistSize = create_art_list.size();
		Artist artist = create_art_list.get(0).getArtist();
		////////////////////////////////////////////////////////////////////////
		WorksDto worksDto = new WorksDto();
		ArtistDto artistDto = new ArtistDto();
		
		BeanUtils.copyProperties(work, worksDto);
		BeanUtils.copyProperties(artist, artistDto);
		
		//type start
		Type2Dto type2Dto = new Type2Dto();
		BeanUtils.copyProperties(work.getType2(), type2Dto);
		Type1Dto type1Dto = new Type1Dto();
		BeanUtils.copyProperties(work.getType2().getType1(), type1Dto);
		type2Dto.setType1Dto(type1Dto);
		worksDto.setType2(type2Dto);
		//type end
		
		Map<String,Object> data = new HashMap();
		
		data.put("work", worksDto);
		data.put("artist", artistDto);
		
		result.setResult(200);
		result.setData(data);
		result.setTotalSize(artistSize);
		
		return result;
	}

	public ResultMap getMatter(WorksDto dto) {
		// TODO Auto-generated method stub
		
		int page = dto.getPageNum() - 1;
		//int page = 1 - 1;
		int size = PageConst.PAGE.PAGE_SIZE;
		
		//just List<Evaluation_itemDto> in resultMap data and totalSize
		ResultMap result = evalDynamicQueryDao.selectMatter(dto.getWork_id(),page,size);
		
//		Page<Evaluation_itemDto> matter_list = this.eval_item_dao.selectMatterListByWorkId(dto.getWork_id(),pageable);
		
		result.setResult(200);
		
		return result;
	}

	/**
	 * 
	 * @param param
	 * @return 
	 * 200
	 * id eval_item_id
	 */
	@Transactional("userTransactionManager")
	public ResultMap saveEval(Map<String, Object> param) {
		// TODO Auto-generated method stub
		
		String ev_text1 = "",ev_text2 = "",subjectMatter = "",base64_evalImage = "";
		int ev_value = 0;
		Long work_id = 0L;
		
		byte[] evalImageByte;
		
		ev_text1 = param.get("ev_text1").toString();
		ev_text2 = param.get("ev_text2").toString();
		subjectMatter = param.get("subjectMatter").toString();
		
		ev_value = Integer.parseInt(param.get("button2").toString());
		work_id = Long.parseLong(param.get("work_id").toString());
		base64_evalImage = param.get("eval_img").toString().split(",")[1];
		
		SimpleUserDto simpleUserDto = CommonSecure.getSimpleUserDto(request);
		Optional<Eva_user> eva_user = eva_user_dao.findById(simpleUserDto.getUserId());
		
		if(eva_user.isPresent() == false) {
			throw new RuntimeException("user is not availables");
		}
		if(ev_value <1 || ev_value >7) {
			throw new RuntimeException("eval value is not correct");
		}
		if(ev_text1.length() ==0 ||  ev_text1.length() >50) {
			throw new RuntimeException("comment1 over character");
		}
		if(ev_text2.length() ==0 ||  ev_text2.length() >50) {
			throw new RuntimeException("comment2 over character");
		}
		if(subjectMatter.length() ==0 ||  subjectMatter.length() >30) {
			throw new RuntimeException("matter over character");
		}
		if(base64_evalImage.isEmpty()) {
			throw new RuntimeException("evalImage empty");
		}
		
		/// evalmage WORK START /////
		evalImageByte = Base64.decodeBase64(base64_evalImage);
		if(evalImageByte.length > FileConst.FILE_SIZE.ONE_MEGA_BYTE) {
			
			throw new RuntimeException("evalImage ERROR FILE SIZE LIMIT EXCESS");
			
		}
		File evalImageFile = new File(FileConst.UPLOAD_CONST.UPLOAD_BASE_PATH);
		FileSave fileSave;
		try {
//			new File(evalImageFile.getCanonicalPath() + FileConst.UPLOAD_CONST.EVAL_IMAGE_BASE_PATH).mkdirs();
//			OutputStream evalImageOut = new FileOutputStream(evalImageFile.getCanonicalPath() + "/evalImage/test.png");
//			evalImageOut.write(evalImageByte);
			fileSave = FileManager.fileSave("EvalImage.png", evalImageByte, FileConst.UPLOAD_CONST.EVAL_IMAGE_BASE_PATH, "png");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("evalImage ERROR");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("evalImage ERROR");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("evalImage ERROR");
		}
		/// evalmage END !!!IMPORTANT!!! filesave save the information of eval item image file/////
		
		WorksDto workdto = new WorksDto();
		workdto.setWork_id(work_id);
		
		//work is availble?? check
		ResultMap workResult = this.getWork(workdto);
		Integer workResult_Integer = workResult.getResult();
		
		if(workResult_Integer != 200) {
			throw new RuntimeException("work is not availble");
		}
		
		//check
		
		Evaluation_item item = new Evaluation_item();
		item.setEv_text1(ev_text1);
		item.setEv_text2(ev_text2);
		item.setSubjectMatter(subjectMatter);
		item.setEv_value(ev_value);
		
		item = eval_item_dao.save(item);
		
		//save eval_item
		Works work_for_saveEval = new Works();
		work_for_saveEval.setWork_id(work_id);
				
		Evaluate eval = new Evaluate();
		eval.setEva_user(eva_user.get());
		eval.setEval_date(LocalDateTime.now());
		eval.setEvaluation_item(item);
		eval.setWorks(work_for_saveEval);
		
		eval = eval_dao.save(eval);
		
		///file save start (img)////
		
		fileSave.setEval_item(item);
		fileSave = fileSaveDao.save(fileSave);
		
		/////file save end(img)///
		
		
		ResultMap result = new ResultMap();
		result.setResult(200);
		result.setId(item.getEval_item_id());
		
		return result;
	}

	public ResultMap evalSerach(Map<String,Object> param) {
		// TODO Auto-generated method stub
		int pageNum = Integer.parseInt(param.get("pageNum").toString());
		int order = Integer.parseInt(param.get("order").toString());
		int order2 = Integer.parseInt(param.get("order2").toString());
		int order3 = Integer.parseInt(param.get("order3").toString());
		
		Long type1 = Long.parseLong(param.get("type1").toString());
		Long type2 = Long.parseLong(param.get("type2").toString());
		
		String searchText = "";
		if(param.get("searchText") != null) {
			searchText = param.get("searchText").toString();
		}
		
		
		Evaluation_itemDto itemDto = new Evaluation_itemDto();
		itemDto.setSearchText(searchText);
		itemDto.setPageNum(pageNum);
		
		Type1Dto type1Dto = new Type1Dto();
		type1Dto.setType1_id(type1);
		
		Type2Dto type2Dto = new Type2Dto();
		type2Dto.setType2_id(type2);
		
		OrderForSearch orderForSearch = new OrderForSearch();
		orderForSearch.setOrder(order);
		orderForSearch.setOrder2(order2);
		orderForSearch.setOrder3(order3);
		
		ResultMap result = evalDynamicQueryDao.selectEvalItemSearchBasic(itemDto,type1Dto,type2Dto,orderForSearch);
		result.setResult(200);
		
		return result;
	}

	public ResultMap evalDetail(Map<String, Object> param) {
		// TODO Auto-generated method stub
		ResultMap result = new ResultMap();
		Long evalItemId = Long.parseLong(param.get("eval_id").toString());
		
		Evaluation_item eval_item = eval_item_dao.findEvaluationItemDetail(evalItemId);
		
		if(eval_item == null) {
			result.setResult(401);
			return result;
		}
		
		//dto setting
		Evaluation_itemDto evalItemDto = new Evaluation_itemDto();
		
		BeanUtils.copyProperties(eval_item, evalItemDto);
		//worksStart
		Evaluate eval = eval_item.getEvaluate().get(0);
		Works work = eval.getWorks();
		WorksDto workDto = new WorksDto();
		BeanUtils.copyProperties(work, workDto);
		//artistStart
		
		List<Create_art> createArtList = new ArrayList<Create_art>();
		createArtList.addAll(work.getCreate());
		
		List<ArtistDto> artistDto_list = new ArrayList<>();
		
		for (Create_art create : createArtList) {
			Artist artist = create.getArtist();
			ArtistDto artistDto = new ArtistDto();

			BeanUtils.copyProperties(artist, artistDto);

			artistDto_list.add(artistDto);
		}
		
		workDto.setArtistDtoList(artistDto_list);
		
		//artist End
		//type start
		Type2Dto type2Dto_var = new Type2Dto();
		Type1Dto type1Dto_var = new Type1Dto();
		
		BeanUtils.copyProperties(work.getType2(), type2Dto_var);
		BeanUtils.copyProperties(work.getType2().getType1(), type1Dto_var);
		
		type2Dto_var.setType1Dto(type1Dto_var);
		workDto.setType2(type2Dto_var);
		//type end
		//filesave start
		List<FileSaveDto> file_list_dto = new ArrayList<FileSaveDto>();

		List<FileSave> file_list = new ArrayList<FileSave>();
		file_list.addAll(work.getFileSave());

		for (FileSave fileSave : file_list) {

			FileSaveDto fileDto = new FileSaveDto();
			BeanUtils.copyProperties(fileSave, fileDto);

			file_list_dto.add(fileDto);
		}
		workDto.setFileSaveDto(file_list_dto);
		//filesave end
		
		evalItemDto.setWork(workDto);
		//work end
		
		//dto setting close
		result.setData(evalItemDto);
		result.setResult(200);
		
		return result;
	}

	public Evaluation_item getEvalDetail(Long eval_id) {
		// TODO Auto-generated method stub
		
		Evaluation_item eval_item = eval_item_dao.findEvaluationItemDetail(eval_id);
		
		return eval_item;
	}
	

}
