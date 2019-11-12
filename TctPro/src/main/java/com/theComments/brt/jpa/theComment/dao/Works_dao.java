package com.theComments.brt.jpa.theComment.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.theComments.brt.jpa.theComment.model.Works;

public interface Works_dao extends JpaRepository<Works, Long> {

	@Query(value = "SELECT w FROM Works w WHERE w.subject LIKE CONCAT('%',:subject,'%')", countQuery = "SELECT count(w) FROM Works w WHERE w.subject LIKE CONCAT('%',:subject,'%')")
	Page<Works> selectWorks(String subject, Pageable pageable);

	@EntityGraph(value = "findByIdDetail_graph",type = EntityGraphType.LOAD)
	@Query(value = "SELECT w FROM Works w WHERE w.work_id = :work_id")
	List<Works> findByIdDetail(Long work_id);

}
