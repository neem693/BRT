package com.theComments.brt.jpa.theComment.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Evaluation_item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long eval_item_id;
	
	String subjectMatter;
	
	String ev_text1;
	String ev_test2;
	
	String donation;
	
	@OneToMany(mappedBy = "evaluation_item")
	List<Evaluate> evaluate;

	
	
	public Long getEval_item_id() {
		return eval_item_id;
	}

	public void setEval_item_id(Long eval_item_id) {
		this.eval_item_id = eval_item_id;
	}

	public String getSubjectMatter() {
		return subjectMatter;
	}

	public void setSubjectMatter(String subjectMatter) {
		this.subjectMatter = subjectMatter;
	}

	public String getEv_text1() {
		return ev_text1;
	}

	public void setEv_text1(String ev_text1) {
		this.ev_text1 = ev_text1;
	}

	public String getEv_test2() {
		return ev_test2;
	}

	public void setEv_test2(String ev_test2) {
		this.ev_test2 = ev_test2;
	}

	public String getDonation() {
		return donation;
	}

	public void setDonation(String donation) {
		this.donation = donation;
	}

	public List<Evaluate> getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(List<Evaluate> evaluate) {
		this.evaluate = evaluate;
	}
	
	
	
	

}
