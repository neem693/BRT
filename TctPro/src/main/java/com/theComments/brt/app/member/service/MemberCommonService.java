package com.theComments.brt.app.member.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.theComments.brt.app.common.CommonSecure;
import com.theComments.brt.app.common.EmailSender;
import com.theComments.brt.auth.SNSAuthorization;
import com.theComments.brt.constFile.EmailInfo;
import com.theComments.brt.constFile.SNS;
import com.theComments.brt.jpa.theComment.dao.Email_templateDao;
import com.theComments.brt.jpa.theComment.dao.Eva_user_dao;
import com.theComments.brt.jpa.theComment.dao.SnsUser_dao;
import com.theComments.brt.jpa.theComment.model.Email_template;
import com.theComments.brt.jpa.theComment.model.Eva_user;
import com.theComments.brt.jpa.theComment.model.Sns_user;
import com.theComments.brt.util.ResultMap;

@Service
public class MemberCommonService {

	@Autowired
	Eva_user_dao userDao;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	SNSAuthorization sns_auth;

	@Autowired
	SnsUser_dao snsUserDao;
	
	@Autowired
	Email_templateDao email_templateDao;

	@Transactional("userTransactionManager")
	public int userCommonJoin(Eva_user user) {

		String encodedPwd = encoder.encode(user.getPassword());
		user.setPassword(encodedPwd);
		user.setJoin_date(LocalDateTime.now());
		user.setEmail_valid(0);
		user.setEmail_verifyKey(CommonSecure.getRandomSecure(60));

//		System.out.println(EmailSender.emailTemplateList);
		user = userDao.save(user);
		//save에 성공하면 email 보내기

		Map<String,Object> param = new HashMap<String, Object>();
		String url = String.format("%s/member/join_success/%s?key=%s",EmailInfo.EMAIL_VERIFY_INFO.url,user.getUser_login_id(),user.getEmail_verifyKey());
		param.put("##{{url}}", url);
		Email_template template = email_templateDao.findById(EmailInfo.EMAIL_VERIFY_INFO.emailTemplateId).get();
		List<String> toList = new ArrayList<String>();
		toList.add(user.getEmail());
		
		try {
			EmailSender.sendEmail(template.getTemplate_subject(), template.getTemplate_text(), param, toList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return 200;
	}

	public int loginIdDuplicate(Eva_user user) {
		// TODO Auto-generated method stub

		List<Eva_user> list = userDao.findByUserLoginId(user.getUser_login_id());
		return list.size();

	}

	public int nicknameCheck(Eva_user user) {
		// TODO Auto-generated method stub

		List<Eva_user> list = userDao.findByNickname(user.getNickname());

		return list.size();
	}

	public int emailDuplicate(Eva_user user) {
		// TODO Auto-generated method stub

		List<Eva_user> list = userDao.findByEmail(user.getEmail());
		return list.size();

	}

	@Transactional("userTransactionManager")
	public int userSnsJoin(Eva_user user) {
		// TODO Auto-generated method stub
		String user_login_id = user.getUser_login_id();
		String snsType = user.getSns_type();
		String access_token = user.getAccess_token();
		String email = user.getEmail();
		Map<String, Object> snsResult = new HashMap<String, Object>();
		Sns_user snsUser = new Sns_user();

		// TODO 액세스 토큰 살아 있나 검토, 이메일도 검증(이메일이 바뀌어져 있으면 가입 불가)
		if (snsType.equals(SNS.GOOGLE.snsType)) {
			snsResult = this.sns_auth.oAuth2TokenApi(snsType, access_token);
			if (snsResult.get("user_id").toString().equals(user_login_id) == false) {
				throw new RuntimeException("4021:sns auth error");
			}
			if (snsResult.get("email").toString().equals(user.getEmail()) == false) {
				throw new RuntimeException("4023:sns email invalid");
			}
		} else if (snsType.equals(SNS.KAKAO.snsType)) {
			snsResult = this.sns_auth.oAuth2TokenApi(snsType, access_token);
			if (snsResult.get("id").toString().equals(user_login_id) == false) {
				throw new BadCredentialsException("4021:sns auth error");
			}
			Map<String, Object> account = (Map<String, Object>) snsResult.get("kakao_account");
			if (account.get("email").toString().equals(user.getEmail()) == false) {
				throw new RuntimeException("4023:sns email invalid");
			}
		} else {
			throw new RuntimeException("4021:sns auth error - ");
		}

		// TODO 본격적인 가입 작업 실행
		// TODO 1. 현재 이메일 중복 되어 있는지 확인--> 만약 등록이 되어 있다면, 등록되어 있다고 가입할 수 없다고 알려주기
		List<Eva_user> user_List = this.userDao.findByEmail(email);
		if (user_List.size() != 0) {
			throw new RuntimeException("4031:email already register");
		}
		// TODO 2. 일단 멤버로 저장
		String encodedPwd = encoder.encode(user.getUser_login_id());
		user.setPassword(encodedPwd);

		String id = String.format("%s%s", CommonSecure.getRandomSecure(10), "_" + snsType);
		while (true) {
			if (userDao.findByUserLoginId(id).size() == 0) {
				break;
			}
			id = String.format("%s%s", CommonSecure.getRandomSecure(10), "_" + snsType);
		}
		user.setUser_login_id(id);
		user.setJoin_date(LocalDateTime.now());
		user.setEmail_valid(1);
		user.setEmail_verifyKey(null);
		user = this.userDao.save(user);
		// TODO 3. 그후 SNS 멤버로 저장
		snsUser.setSns_user_unique_id(user_login_id);
		snsUser.setSns_email(email);
		snsUser.setAccess_token(access_token);
		snsUser.setSns_type(snsType);
		snsUser.setEva_user(user);
		snsUser = snsUserDao.save(snsUser);
		// TODO 4. 더 할게 있나??

		return 200;

	}

	public ResultMap emailVerify(Map<String, Object> data) {
		// TODO Auto-generated method stub
		
		ResultMap result = new ResultMap();
		
		String user_login_id = data.get("user_login_id").toString();
		String key = data.get("key").toString();
		
		List<Eva_user> userList = this.userDao.findByUserLoginId(user_login_id);
		if(userList.size() == 0) {
			result.setResult(401);
			return result;
		}
		
		Eva_user user = userList.get(0);
		if(key.equals(user.getEmail_verifyKey())) {
			result.setResult(200);
			user.setEmail_valid(1);
			user.setEmail_verifyKey(null);
			userDao.save(user);
		}else {
			result.setResult(401);
		}
		
		return result;
	}

}
