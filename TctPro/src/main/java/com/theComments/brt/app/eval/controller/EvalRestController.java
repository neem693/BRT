package com.theComments.brt.app.eval.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.theComments.brt.app.eval.service.EvalService;
import com.theComments.brt.jpa.dto.WorksDto;
import com.theComments.brt.util.ResultMap;

@RestController
@RequestMapping("/v1/eval")
public class EvalRestController {
	
	@Autowired
	EvalService evalService;
	
	@RequestMapping(value="/getWork",method = RequestMethod.GET)
	public Map<String,Object> getWork(@RequestParam Map<String,Object> param){
		
		WorksDto dto = new WorksDto();
		dto.setWork_id(Long.parseLong(param.get("work_id").toString()));
		
		ResultMap resultMap = this.evalService.getWork(dto);
		
		return resultMap.getResultMap();
		
	}
	
	@RequestMapping(value="/getMatter",method = RequestMethod.GET)
	public Map<String,Object> getMatter(@RequestParam Map<String,Object> param){
		
		WorksDto dto = new WorksDto();
		dto.setWork_id(Long.parseLong(param.get("work_id").toString()));
		dto.setPageNum(Integer.parseInt(param.get("pageNum").toString()));
//		BeanUtils.copyProperties(param, dto);
		
		ResultMap resultMap = this.evalService.getMatter(dto);
		
		return resultMap.getResultMap();
		
	}
	
	@RequestMapping(value = "/saveEval",method = RequestMethod.POST)
	public Map<String,Object> saveEval(@RequestBody Map<String,Object> param){
		
		ResultMap result = this.evalService.saveEval(param);
		
		return result.getResultMap();
		
	}
	

}
