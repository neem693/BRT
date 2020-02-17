package com.theComments.brt.jpa.theComment.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.theComments.brt.jpa.theComment.model.Evaluation_item;

public interface Evaluation_item_dao extends JpaRepository<Evaluation_item, Long> {

	@Query("SELECT item "
			+ "FROM Evaluation_item item "
			+ "WHERE item.eval_item_id = :eval_item_id AND item.delYn = 0")
	@EntityGraph(value = "evaluation_item.listMain",type = EntityGraphType.LOAD)
	Evaluation_item findEvaluationItemDetail(Long eval_item_id);

	@Query("SELECT item "
			+ "FROM Evaluation_item item "
			+ "JOIN item.evaluate ev "
			+ "JOIN ev.works w "
			+ "JOIN w.type2 t2 "
			+ "JOIN t2.type1 t1 "
			+ "WHERE t1.type1_id = :type1 AND item.delYn = 0 "
			+ "AND w.delYn =0 "
			+ "ORDER BY ev.eval_date desc")
	@EntityGraph(value = "evaluation_item.listMain",type = EntityGraphType.LOAD)
	Page<Evaluation_item> selectMain(Long type1, Pageable pageable);

	
}
