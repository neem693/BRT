package com.theComments.brt.jpa.theComment.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.theComments.brt.jpa.theComment.model.Eva_user;
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

	@Query("SELECT s FROM Sns_user s WHERE s.sns_user_unique_id = :sns_user_unique_id")
	public List<Sns_user> findBySns_user_unique_id(String sns_user_unique_id);
	
	@Query("SELECT s FROM Sns_user s JOIN s.eva_user u "
			+ "WHERE u.user_id = :user_id")
	public List<Sns_user> findByEva_user(Long user_id);
	
	
	
}
