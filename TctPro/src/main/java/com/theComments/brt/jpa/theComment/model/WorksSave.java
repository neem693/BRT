package com.theComments.brt.jpa.theComment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class WorksSave {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long work_save_id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	Eva_user eva_user;	
	
	@ManyToOne
	@JoinColumn(name="work_id")
	Works works;

	public Long getWork_save_id() {
		return work_save_id;
	}

	public void setWork_save_id(Long work_save_id) {
		this.work_save_id = work_save_id;
	}

	public Eva_user getEva_user() {
		return eva_user;
	}

	public void setEva_user(Eva_user eva_user) {
		this.eva_user = eva_user;
	}

	public Works getWorks() {
		return works;
	}

	public void setWorks(Works works) {
		this.works = works;
	}
	
	
	

}
