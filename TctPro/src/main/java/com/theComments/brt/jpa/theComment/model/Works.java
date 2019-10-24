package com.theComments.brt.jpa.theComment.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Works {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long work_id;
	
	@ManyToOne
	@JoinColumn(name="type2_id")
	Type2 type2;
	
	String subject;
	
	@OneToMany(mappedBy="works")
	List<Evaluate> evaluate;
	
	@OneToMany(mappedBy="works")
	List<WorksSave> worksSave;
	
	@OneToMany(mappedBy="works")
	List<Create_art> create;
	
	@OneToMany(mappedBy="works")
	List<FileSave> fileSave;
	
	int is_series;
	
	@Column(nullable=false)
	LocalDateTime create_date;
	LocalDateTime create_end_date2;

	public Long getWork_id() {
		return work_id;
	}

	public void setWork_id(Long work_id) {
		this.work_id = work_id;
	}

	public Type2 getType2() {
		return type2;
	}

	public void setType2(Type2 type2) {
		this.type2 = type2;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public List<FileSave> getFileSave() {
		return fileSave;
	}

	public void setFileSave(List<FileSave> fileSave) {
		this.fileSave = fileSave;
	}

	public int getIs_series() {
		return is_series;
	}

	public void setIs_series(int is_series) {
		this.is_series = is_series;
	}

	public LocalDateTime getCreate_date() {
		return create_date;
	}

	public void setCreate_date(LocalDateTime create_date) {
		this.create_date = create_date;
	}

	public LocalDateTime getCreate_end_date2() {
		return create_end_date2;
	}

	public void setCreate_end_date2(LocalDateTime create_end_date2) {
		this.create_end_date2 = create_end_date2;
	}

	
	
	
	
	


}
