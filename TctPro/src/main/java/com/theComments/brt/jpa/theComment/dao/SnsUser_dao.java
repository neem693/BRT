package com.theComments.brt.jpa.theComment.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.theComments.brt.jpa.theComment.model.Sns_user;

public interface SnsUser_dao extends JpaRepository<Sns_user, Long> {
	
	/**
	 * sns 로그인 시에 사용하는 로그인 쿼리
	 * @param sns_user_unique_id
	 * @return
	 */
	@Query("SELECT s "
			+ "FROM Sns_user s JOIN FETCH s.eva_user u "
			+ "WHERE s.sns_user_unique_id = :sns_user_unique_id "
			+ "AND s.sns_type = :sns_type")
	public Optional<Sns_user> findSnsUser(String sns_user_unique_id,String sns_type);

}
