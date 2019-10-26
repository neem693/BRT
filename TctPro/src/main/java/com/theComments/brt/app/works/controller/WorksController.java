package com.theComments.brt.app.works.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.theComments.brt.app.works.service.WorksService;
import com.theComments.brt.jpa.theComment.dao.Type2_dao;
import com.theComments.brt.jpa.theComment.model.Type2;
import com.theComments.brt.jpa.theComment.model.Works;
import com.theComments.brt.util.ResultMap;

@RestController
@RequestMapping("/v1/works")
public class WorksController {

	@Autowired
	WorksService worksService;
	
	@Autowired
	HttpServletResponse response;

	@RequestMapping(value = "/workSave",method = RequestMethod.POST)
	public Map<String,Object> worksSave(@RequestParam("fileList") MultipartFile[] f, @RequestParam Map<String, Object> data) throws Exception {

		ResultMap result = worksService.saveWorks(f, data);
		
		int result_code = result.getResult();
		
		if(result_code == 200) {
			
		}
		if(result_code == 201) {
			result.setMessage("201111:need Artist to regist");
		}
		
		return result.getResultMap();

	}
	
	@RequestMapping(value = "/worksSelectOne",method = RequestMethod.GET)
	public Map<String,Object> worksSelectOne(@RequestParam Map<String,Object> param) {

		ResultMap result = worksService.worksSelectOne(param);
		
		int result_code = result.getResult();
		
		if(result_code == 200) {
			
		}
		if(result_code == 201) {
			//result.setMessage("201111:need Artist to regist");
		}
		
		return result.getResultMap();

	}

}
