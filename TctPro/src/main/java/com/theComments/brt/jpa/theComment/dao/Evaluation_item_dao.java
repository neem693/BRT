package com.theComments.brt.jpa.theComment.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.theComments.brt.jpa.theComment.model.Evaluation_item;

public interface Evaluation_item_dao extends JpaRepository<Evaluation_item, Long> {

	@Query("SELECT item "
			+ "FROM Evaluation_item item "
			+ "WHERE item.eval_item_id = :eval_item_id")
	@EntityGraph(value = "evaluation_item.listMain",type = EntityGraphType.LOAD)
	Evaluation_item findEvaluationItemDetail(Long eval_item_id);

	
}
