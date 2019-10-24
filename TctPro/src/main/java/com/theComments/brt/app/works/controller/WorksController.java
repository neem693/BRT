package com.theComments.brt.app.works.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.theComments.brt.app.works.service.WorksService;
import com.theComments.brt.jpa.theComment.dao.Type2_dao;
import com.theComments.brt.jpa.theComment.model.Type2;
import com.theComments.brt.jpa.theComment.model.Works;

@RestController
@RequestMapping("/v1/works")
public class WorksController {

	@Autowired
	WorksService worksService;

	@RequestMapping(value = "/workSave")
	public void worksSave(@RequestParam("fileList") MultipartFile[] f, @RequestParam Map<String, Object> data) throws Exception {

		System.out.println(f);
		int result = worksService.saveWorks(f, data);

	}

}
