package com.theComments.brt.app.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.theComments.brt.jpa.theComment.dao.Eva_user_dao;
import com.theComments.brt.jpa.theComment.model.Eva_user;

@Service
public class MemberCommonService {

	@Autowired
	Eva_user_dao userDao;

	@Transactional("userTransactionManager")
	public int userCommonJoin(Eva_user user) {

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

}
