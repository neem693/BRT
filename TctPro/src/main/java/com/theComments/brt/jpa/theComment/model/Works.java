package com.theComments.brt.jpa.theComment.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Works {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long work_id;
	
	String subject;
	
	Integer type1;
	Integer type2;
	
	@OneToMany(mappedBy="works")
	List<Evaluate> evaluate;
	
	@OneToMany(mappedBy="works")
	List<WorksSave> worksSave;
	
	@OneToMany(mappedBy="works")
	List<Create_art> create;

	public Long getWork_id() {
		return work_id;
	}

	public void setWork_id(Long work_id) {
		this.work_id = work_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getType1() {
		return type1;
	}

	public void setType1(Integer type1) {
		this.type1 = type1;
	}

	public Integer getType2() {
		return type2;
	}

	public void setType2(Integer type2) {
		this.type2 = type2;
	}

	public List<Evaluate> getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(List<Evaluate> evaluate) {
		this.evaluate = evaluate;
	}

	public List<WorksSave> getWorksSave() {
		return worksSave;
	}

	public void setWorksSave(List<WorksSave> worksSave) {
		this.worksSave = worksSave;
	}

	public List<Create_art> getCreate() {
		return create;
	}

	public void setCreate(List<Create_art> create) {
		this.create = create;
	}
	
	
	


}
