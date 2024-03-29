package com.theComments.brt.app.works.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.theComments.brt.app.works.service.WorksService;
import com.theComments.brt.jsonView.BRTJsonView;
import com.theComments.brt.util.ResultMap;

@RestController
@RequestMapping("/v1/worksPublic")
public class WorksPublicRestController {
	
	@Autowired
	WorksService worksService;
	
	
	@RequestMapping(value = "/worksSearch",method = RequestMethod.GET)
	@JsonView(BRTJsonView.WorksCommon.class)
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
	@JsonView(BRTJsonView.WorksCommon.class)
	public Map<String,Object> worksSearchDetail(@RequestParam Map<String,Object> param){
		
		ResultMap result = worksService.worksSearchDetail(param);
		
		return result.getResultMap();
	}
	
	/**
	 * select artist detail information of see, doo, listen works
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/selectWorksByArtist",method = RequestMethod.GET)
	@JsonView(BRTJsonView.WorksCommon.class)
	public Map<String,Object> selectWorksByArtist(Long id){
		
		ResultMap result = worksService.selectWorksByArtist(id);
		
		return result.getResultMap();
		
	}
	
	/**
	 * one by one
	 * selectWorksByArtist
	 * @param param (type1,pageNum
	 * @return
	 */
	@RequestMapping(value="/selectSeeListenDooAndPage",method = RequestMethod.GET)
	public Map<String,Object> selectSeeListenDooAndPage(@RequestParam Map<String,Object> param){
		ResultMap result = worksService.selectSeeListenDooAndPage(param);
		
		return result.getResultMap();
	}
}
