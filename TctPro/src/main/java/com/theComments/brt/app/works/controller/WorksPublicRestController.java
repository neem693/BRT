package com.theComments.brt.app.works.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.theComments.brt.app.works.service.WorksService;
import com.theComments.brt.util.ResultMap;

@RestController
@RequestMapping("/v1/worksPublic")
public class WorksPublicRestController {
	
	@Autowired
	WorksService worksService;
	
	
	@RequestMapping(value = "/worksSearch",method = RequestMethod.GET)
	public Map<String,Object> worksSearch(@RequestParam Map<String,Object> param){
		/**
		 * search variable
		 * ##order##
		 * 0:eval count
		 * 1:realse time
		 * ##order2##
		 * 0:desend
		 * 1:accend
		 */
		
		ResultMap result = worksService.worksSearch(param);
		
		
		return result.getResultMap();
	}
	
	@RequestMapping(value = "/worksSearchDetail",method = RequestMethod.GET)
	public Map<String,Object> worksSearchDetail(@RequestParam Map<String,Object> param){
		
		ResultMap result = worksService.worksSearchDetail(param);
		
		return result.getResultMap();
	}

}
