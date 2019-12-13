package com.theComments.brt.app.eval.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.theComments.brt.app.eval.service.EvalService;
import com.theComments.brt.jpa.dto.Evaluation_itemDto;
import com.theComments.brt.util.ResultMap;

@RestController
@RequestMapping("/v1/evalPublic")
public class EvalPublicRestController {
	
	
	@Autowired
	EvalService evalService;
	
	
	@RequestMapping(value = "/evalSearch",method = RequestMethod.GET)
	public Map<String,Object> evalSearch(@RequestParam Map<String,Object> param){
		
		ResultMap result = evalService.evalSerach(param);
		
		return result.getResultMap();
		
	}
	
	@RequestMapping(value = "/evalDetail",method = RequestMethod.GET)
	public Map<String,Object> evalDetail(@RequestParam Map<String,Object> param){
		
		ResultMap result = evalService.evalDetail(param);
		
		return result.getResultMap();
		
	}

}
