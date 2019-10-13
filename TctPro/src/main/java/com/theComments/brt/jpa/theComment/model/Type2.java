package com.theComments.brt.jpa.theComment.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Type2 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long type2_id;
	
	String type2_name;
	
	@ManyToOne
	@JoinColumn(name="type1_id")
	Type1 type1;
	
	@OneToMany(mappedBy="type2")
	List<Works> works;

	public Long getType2_id() {
		return type2_id;
	}

	public void setType2_id(Long type2_id) {
		this.type2_id = type2_id;
	}

	public String getType2_name() {
		return type2_name;
	}

	public void setType2_name(String type2_name) {
		this.type2_name = type2_name;
	}

	public Type1 getType1() {
		return type1;
	}

	public void setType1(Type1 type1) {
		this.type1 = type1;
	}

	public List<Works> getWorks() {
		return works;
	}

	public void setWorks(List<Works> works) {
		this.works = works;
	}
	
	

}
