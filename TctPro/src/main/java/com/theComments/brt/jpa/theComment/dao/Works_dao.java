package com.theComments.brt.jpa.theComment.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.theComments.brt.jpa.theComment.model.Works;

public interface Works_dao extends JpaRepository<Works, Long> {
	
	@EntityGraph(value = "findByIdDetail_graph",type = EntityGraphType.LOAD)
	Optional<Works> findById(Long id);

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
			+ "t1.type1_id = :type1 "
			+ "ORDER BY w.create_date desc ",
			countQuery = "SELECT count(*) FROM Works w "
					+ "JOIN w.create wc "
					+ "JOIN wc.artist a "
					+ "JOIN w.type2 t2 "
					+ "JOIN t2.type1 t1 "
					+ "WHERE a.artist_id = :id AND "
					+ "t1.type1_id = :type1 "
					)
	Page<Works> searchWorksSeeListenDoo(Long id,Long type1, Pageable pageable);
	

}
