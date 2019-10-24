package com.theComments.brt.jpa.theComment.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.theComments.brt.jpa.theComment.model.Type2;

public interface Type2_dao extends JpaRepository<Type2, Long> {

	@Query(
			value = "select t2 FROM Type2 t2 "
					+ "ORDER BY t2.type2_name DESC",
			countQuery = "select count(t2) FROM Type2 t2"
			)
	Page<Type2> selectType2OrderByName(Pageable pageable);

}
