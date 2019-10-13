package com.theComments.brt.jpa.theComment.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Type1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long type1_id;
	
	String type1_name;
	
	@OneToMany(mappedBy="type1")
	List<Type2> type2;

	public Long getType1_id() {
		return type1_id;
	}

	public void setType1_id(Long type1_id) {
		this.type1_id = type1_id;
	}

	public String getType1_name() {
		return type1_name;
	}

	public void setType1_name(String type1_name) {
		this.type1_name = type1_name;
	}

	public List<Type2> getType2() {
		return type2;
	}

	public void setType2(List<Type2> type2) {
		this.type2 = type2;
	}
	
	

}
