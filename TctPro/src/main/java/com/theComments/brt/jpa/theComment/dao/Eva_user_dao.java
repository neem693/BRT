package com.theComments.brt.jpa.theComment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.theComments.brt.jpa.theComment.model.Eva_user;

public interface Eva_user_dao extends JpaRepository<Eva_user,Long>{
	
	@Query("SELECT user "
			+ "FROM Eva_user user "
			+ "where user.user_login_id = :user_login_id")
	List<Eva_user> findByUserLoginId(@Param("user_login_id")String user_login_id);
	
	List<Eva_user> findByEmail(String email);
	

}
