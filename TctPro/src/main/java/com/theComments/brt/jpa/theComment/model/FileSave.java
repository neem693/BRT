package com.theComments.brt.jpa.theComment.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Setter;

import lombok.Getter;

@Entity
@Getter
@Setter
public class FileSave {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long file_id;

	String file_name;
	String file_path;
	String save_file_name;
	String save_file_path;
	String file_type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "work_id")
	Works works;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "eval_item_id")
	Evaluation_item eval_item;


}
