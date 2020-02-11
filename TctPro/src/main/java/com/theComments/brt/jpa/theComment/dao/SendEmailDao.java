package com.theComments.brt.jpa.theComment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;

import com.theComments.brt.jpa.theComment.model.SendEmail;


public interface SendEmailDao extends JpaRepository<SendEmail, Long>{

	@Query("SELECT se FROM SendEmail se WHERE se.status = 0 ")
	@EntityGraph(value = "loadingEmail_template",type = EntityGraphType.LOAD)
	List<SendEmail> findNotSendEmail();

}
