package com.theComments.brt.app.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.theComments.brt.app.member.service.MemberCommonService;
import com.theComments.brt.jpa.theComment.dao.Eva_user_dao;
import com.theComments.brt.jpa.theComment.model.Eva_user;

@RestController
@RequestMapping("/v1/member_public")
public class MemberPublicRestController {
	
	@Autowired
	HttpServletResponse res;
	
	@Autowired
	CookieCsrfTokenRepository csrf;
	
	@Autowired
	HttpServletRequest req;
	
	@Autowired
	MemberCommonService memberCommonService;
	

	@RequestMapping(value="/joinMember_common",method=RequestMethod.POST)
	public void saveMember(@RequestBody Eva_user user) {
		
		System.out.println(user);
		memberCommonService.userCommonJoin(user);
		
//		user.setPassword(password);
		
	}
	
	@RequestMapping(value="/joinMember_sns",method=RequestMethod.POST)
	public void saveMemberSns(@RequestBody Eva_user user) throws IOException {
		
		try {
			memberCommonService.userSnsJoin(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			res.sendError(400, e.getMessage());
		}
		
//		user.setPassword(password);
		
	}
	
	@RequestMapping(value="/loginIdDuplicate",method=RequestMethod.POST)
	public Map<String,Object> loginIdDuplicate(@RequestBody Eva_user user) {
		
		int result = memberCommonService.loginIdDuplicate(user);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("dup", result);
		return map;

	}
	
	@RequestMapping(value="/emailDuplicate",method=RequestMethod.POST)
	public Map<String,Object> emailDuplicate(@RequestBody Eva_user user) {
		
		int result = memberCommonService.emailDuplicate(user);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("dup", result);
		return map;

	}
	
	@RequestMapping(value="/nicknameCheck",method=RequestMethod.POST)
	public Map<String,Object> nicknameCheck(@RequestBody Eva_user user) {
		
		int result = memberCommonService.nicknameCheck(user);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("dup", result);
		return map;
		
	}
	
	
	
	@RequestMapping(value="/csrfTokenGen",method=RequestMethod.GET)
	public Map<String,Object> getCsrfToken() {
		
		CsrfToken token = csrf.loadToken(req);
		if(token == null) {
			token = csrf.generateToken(req);
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("token", token.getToken());
		return map;
		
	}

}
