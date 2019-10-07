package com.theComments.brt.jpa.theComment.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Evaluate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long eval_id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	Eva_user eva_user;
	
	@ManyToOne
	@JoinColumn(name="eval_item_id")
	Evaluation_item evaluation_item;
	
	@ManyToOne
	@JoinColumn(name="works_id")
	Works works;
	
	////더 많은 조인 컬럼들

	LocalDateTime eval_date;

	public Long getEval_id() {
		return eval_id;
	}

	public void setEval_id(Long eval_id) {
		this.eval_id = eval_id;
	}

	public Eva_user getEva_user() {
		return eva_user;
	}

	public void setEva_user(Eva_user eva_user) {
		this.eva_user = eva_user;
	}

	public Evaluation_item getEvaluation_item() {
		return evaluation_item;
	}

	public void setEvaluation_item(Evaluation_item evaluation_item) {
		this.evaluation_item = evaluation_item;
	}

	public Works getWorks() {
		return works;
	}

	public void setWorks(Works works) {
		this.works = works;
	}

	public LocalDateTime getEval_date() {
		return eval_date;
	}

	public void setEval_date(LocalDateTime eval_date) {
		this.eval_date = eval_date;
	}

	
	
	
	

	
	

}
