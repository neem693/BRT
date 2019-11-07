package com.theComments.brt.jpa.theComment.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.theComments.brt.jpa.dto.Evaluation_itemDto;
import com.theComments.brt.jpa.theComment.model.Evaluation_item;

public interface Evaluation_item_dao extends JpaRepository<Evaluation_item, Long> {

	
	@Query(value = "SELECT \r\n" + 
			"result.subjectMatter,\r\n" + 
			"SUM(CASE WHEN result.ev_value>=6 THEN 1 ELSE 0 END) as yellow,\r\n" + 
			"SUM(CASE WHEN result.ev_value>=4 and result.ev_value <=5 THEN 1 ELSE 0 END) as blue,\r\n" + 
			"SUM(CASE WHEN result.ev_value>=2 and result.ev_value <=3 THEN 1 ELSE 0 END) as gray,\r\n" + 
			"SUM(CASE WHEN result.ev_value>=1 THEN 1 ELSE 0 END) as black\r\n" + 
			"FROM(\r\n" + 
			"SELECT ei.subjectMatter,ei.ev_value\r\n" + 
			"FROM evaluation_item ei \r\n" + 
			"INNER JOIN evaluate e\r\n" + 
			"ON ei.eval_item_id = e.eval_item_id \r\n" + 
			"INNER JOIN WORKS w\r\n" + 
			"ON w.work_id = e.works_id\r\n" + 
			"WHERE w.work_id = :work_id\r\n" + 
			") as result\r\n" + 
			"GROUP BY result.subjectMatter\r\n",
			nativeQuery = true,
			countQuery = "SELECT count(*)"
					+ "FROM evaluation_item ei"
					+ "INNER JOIN evaluate e"
					+ "ON ei.eval_item_id = e.eval_item_id"
					+ "INNER JOIN WORKS w"
					+ "ON w.work_id = e.works_id"
					+ "WHERE w.work_id = :work_id")
	Page<Evaluation_itemDto> selectMatterListByWorkId(Long work_id,Pageable pageable);

}
