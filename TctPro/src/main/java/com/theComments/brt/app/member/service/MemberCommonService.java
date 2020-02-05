package com.theComments.brt.app.member.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.theComments.brt.app.common.CommonSecure;
import com.theComments.brt.auth.SNSAuthorization;
import com.theComments.brt.constFile.SNS;
import com.theComments.brt.jpa.theComment.dao.Eva_user_dao;
import com.theComments.brt.jpa.theComment.dao.SnsUser_dao;
import com.theComments.brt.jpa.theComment.model.Eva_user;
import com.theComments.brt.jpa.theComment.model.Sns_user;

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

	@Transactional("userTransactionManager")
	public int userCommonJoin(Eva_user user) {

		String encodedPwd = encoder.encode(user.getPassword());
		user.setPassword(encodedPwd);
		user.setJoin_date(LocalDateTime.now());

		userDao.save(user);
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

}
