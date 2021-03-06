package com.theComments.brt.jpa.theComment.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.theComments.brt.jpa.theComment.model.Artist;
import com.theComments.brt.jpa.theComment.model.Type1;

public interface Type1_dao extends JpaRepository<Type1, Long> {
	
	
	@Query("SELECT t1 FROM Type1 t1")
	@EntityGraph(attributePaths = {"type2"},type = EntityGraphType.LOAD)
	public List<Type1> getAllType();

}
