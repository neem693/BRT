package com.theComments.brt.jpa.theComment.dao;

import java.util.List;
import java.util.Map;

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

	@EntityGraph(value = "SelectWorksByArtist",type = EntityGraphType.LOAD)
	@Query(value = "SELECT w FROM Works w "
			+ "JOIN w.create wc "
			+ "JOIN wc.artist a "
			+ "JOIN w.type2 t2 "
			+ "JOIN t2.type1 t1 "
			+ "WHERE a.artist_id = :id AND "
			+ "t1.type1_id = 1 "
			+ "ORDER BY wc.save_date desc ",
			countQuery = "SELECT count(*) FROM Works w "
					+ "JOIN w.create wc "
					+ "JOIN wc.artist a "
					+ "JOIN w.type2 t2 "
					+ "JOIN t2.type1 t1 "
					+ "WHERE a.artist_id = :id AND "
					+ "t1.type1_id = 1 "
					+ "ORDER BY wc.save_date desc ")
	Page<Works> searchWorksSee(Long id, Pageable pageable);

	@EntityGraph(value = "SelectWorksByArtist",type = EntityGraphType.LOAD)
	@Query(value = "SELECT w FROM Works w "
			+ "JOIN w.create wc "
			+ "JOIN wc.artist a "
			+ "JOIN w.type2 t2 "
			+ "JOIN t2.type1 t1 "
			+ "WHERE a.artist_id = :id AND "
			+ "t1.type1_id = 2 "
			+ "ORDER BY wc.save_date desc ",
			countQuery = "SELECT count(*) FROM Works w "
					+ "JOIN w.create wc "
					+ "JOIN wc.artist a "
					+ "JOIN w.type2 t2 "
					+ "JOIN t2.type1 t1 "
					+ "WHERE a.artist_id = :id AND "
					+ "t1.type1_id = 2 "
					+ "ORDER BY wc.save_date desc ")
	Page<Works> searchWorksListen(Long id , Pageable pageable);

	@EntityGraph(value = "SelectWorksByArtist",type = EntityGraphType.LOAD)
	@Query(value = "SELECT w FROM Works w "
			+ "JOIN w.create wc "
			+ "JOIN wc.artist a "
			+ "JOIN w.type2 t2 "
			+ "JOIN t2.type1 t1 "
			+ "WHERE a.artist_id = :id AND "
			+ "t1.type1_id = 3 "
			+ "ORDER BY wc.save_date desc ",
			countQuery = "SELECT count(*) FROM Works w "
					+ "JOIN w.create wc "
					+ "JOIN wc.artist a "
					+ "JOIN w.type2 t2 "
					+ "JOIN t2.type1 t1 "
					+ "WHERE a.artist_id = :id AND "
					+ "t1.type1_id = 3 "
					+ "ORDER BY wc.save_date desc ")
	Page<Works> searchWorksDoo(Long id , Pageable pageable);

}
