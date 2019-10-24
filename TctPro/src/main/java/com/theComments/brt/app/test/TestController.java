package com.theComments.brt.app.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theComments.brt.jpa.dto.Type2Dto;
import com.theComments.brt.jpa.theComment.dao.Type2_dao;
import com.theComments.brt.jpa.theComment.model.Type2;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	Type2_dao dao;
	
	@RequestMapping("/t")
	public List<Type2Dto> getTestValue() {
		
		Pageable pageable = PageRequest.of(0, 3);
		
		Page<Type2> page =  dao.findAll(pageable);
		System.out.println(page);
		
		Page<Type2> type2Page = dao.selectType2OrderByName(pageable);
		System.out.println(type2Page);
		return null;
		
	}

}
