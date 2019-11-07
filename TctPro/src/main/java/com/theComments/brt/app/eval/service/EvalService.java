package com.theComments.brt.app.eval.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.bouncycastle.crypto.RuntimeCryptoException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.theComments.brt.app.common.CommonSecure;
import com.theComments.brt.constFile.PageConst;
import com.theComments.brt.jpa.dto.ArtistDto;
import com.theComments.brt.jpa.dto.EvaluateDto;
import com.theComments.brt.jpa.dto.Evaluation_itemDto;
import com.theComments.brt.jpa.dto.WorksDto;
import com.theComments.brt.jpa.theComment.dao.Evaluate_dao;
import com.theComments.brt.jpa.theComment.dao.Evaluation_item_dao;
import com.theComments.brt.jpa.theComment.dao.Works_dao;
import com.theComments.brt.jpa.theComment.model.Artist;
import com.theComments.brt.jpa.theComment.model.Create_art;
import com.theComments.brt.jpa.theComment.model.Eva_user;
import com.theComments.brt.jpa.theComment.model.Evaluate;
import com.theComments.brt.jpa.theComment.model.Evaluation_item;
import com.theComments.brt.jpa.theComment.model.Works;
import com.theComments.brt.util.ResultMap;

@Service
public class EvalService {
	
	@Autowired
	Works_dao works_dao;
	
	@Autowired
	Evaluation_item_dao eval_item_dao;
	
	@Autowired
	Evaluate_dao eval_dao;
	
	@Autowired
	HttpServletRequest request;

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
		List<Create_art> create_art_list = work.getCreate();
		
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

		Pageable pageable = PageRequest.of(page, size);
		
		Page<Evaluation_itemDto> matter_list = this.eval_item_dao.selectMatterListByWorkId(dto.getWork_id(),pageable);
		
		ResultMap result = new ResultMap();
		result.setResult(200);
		result.setData(matter_list.getContent());
		result.setTotalSize(matter_list.getTotalElements());
		
		return result;
	}

	@Transactional("userTransactionManager")
	public ResultMap saveEval(Map<String, Object> param) {
		// TODO Auto-generated method stub
		
		String ev_text1 = "",ev_text2 = "",subjectMatter = "";
		int ev_value = 0;
		Long work_id = 0L;
		
		ev_text1 = param.get("ev_text1").toString();
		ev_text2 = param.get("ev_text2").toString();
		subjectMatter = param.get("subjectMatter").toString();
		
		ev_value = Integer.parseInt(param.get("button2").toString());
		work_id = Long.parseLong(param.get("work_id").toString());
		
		CommonSecure secure = new CommonSecure();
		secure.getSimpleUserDto(request)
		Eva_user eva_user = new Eva_user();
		
		if(ev_text1.length() ==0 ||  ev_text1.length() >50) {
			throw new RuntimeException("comment1 over character");
		}
		if(ev_text2.length() ==0 ||  ev_text2.length() >50) {
			throw new RuntimeException("comment2 over character");
		}
		if(subjectMatter.length() ==0 ||  subjectMatter.length() >30) {
			throw new RuntimeException("matter over character");
		}
		
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
		
		item = eval_item_dao.save(item);
		
		//save eval_item
		
		Evaluate eval = new Evaluate();
		e
		
		return null;
	}
	
	
	

}
