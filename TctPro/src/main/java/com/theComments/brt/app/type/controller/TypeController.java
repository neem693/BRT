package com.theComments.brt.app.type.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theComments.brt.constFile.AuthUser;
import com.theComments.brt.jpa.dto.Type1Dto;
import com.theComments.brt.jpa.dto.Type2Dto;
import com.theComments.brt.jpa.theComment.dao.Type1_dao;
import com.theComments.brt.jpa.theComment.dao.Type2_dao;
import com.theComments.brt.jpa.theComment.model.Type1;
import com.theComments.brt.jpa.theComment.model.Type2;

@RestController
@RequestMapping("/v1/type")
public class TypeController {
	
	@Autowired
	Type1_dao type1_dao;

	
	@RequestMapping(value = "/getWorkAllType",method = RequestMethod.GET)
	public List<Type1Dto> getWorkType(){
		
//		List<Type1> list = type1_dao.getAllType();
		List<Type1> type1List = type1_dao.findAll();
		
		List<Type1Dto> type1dtoList = new ArrayList<Type1Dto>();
		
		
		for(Type1 type : type1List) {
			Type1Dto type1dto = new Type1Dto();
			BeanUtils.copyProperties(type, type1dto);
			
			List<Type2> type2List = type.getType2();
			List<Type2Dto> dto2List = new ArrayList<Type2Dto>();
			
			for(Type2 type2 : type2List) {
				Type2Dto dto2 = new Type2Dto();
				BeanUtils.copyProperties(type2, dto2);
				dto2List.add(dto2);
			}
			type1dto.setType2Dto(dto2List);
			
			type1dtoList.add(type1dto);
		}

		
		
		return type1dtoList;
	}

}
