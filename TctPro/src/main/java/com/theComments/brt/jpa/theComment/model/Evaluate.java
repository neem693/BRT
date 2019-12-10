package com.theComments.brt.jpa.theComment.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Setter;

import lombok.Getter;

@Entity
@Getter
@Setter
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
	
	
	
	

	
	

}
