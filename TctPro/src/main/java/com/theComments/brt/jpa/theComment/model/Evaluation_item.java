package com.theComments.brt.jpa.theComment.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;

import org.springframework.web.bind.annotation.RequestMapping;


@SqlResultSetMapping(
		name = "selectSubjectMatterGroup",
		classes = {
				@ConstructorResult(
						targetClass = com.theComments.brt.jpa.dto.Evaluation_itemDto.class,
						columns = {
							@ColumnResult(name="subjectMatter",type=String.class),
							@ColumnResult(name="yellow",type=Integer.class),
							@ColumnResult(name="blue",type=Integer.class),
							@ColumnResult(name="gray",type=Integer.class),
							@ColumnResult(name="black",type=Integer.class)
						})
		})
@Entity
public class Evaluation_item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long eval_item_id;
	
	String subjectMatter;
	
	String ev_text1;
	String ev_text2;
	@Column(nullable = false)
	Integer ev_value;
	
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

	public String getEv_text2() {
		return ev_text2;
	}

	public void setEv_text2(String ev_text2) {
		this.ev_text2 = ev_text2;
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

	public Integer getEv_value() {
		return ev_value;
	}

	public void setEv_value(Integer ev_value) {
		this.ev_value = ev_value;
	}
	
	
	
	

}
