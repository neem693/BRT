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

import com.fasterxml.jackson.annotation.JsonView;
import com.theComments.brt.jsonView.BRTJsonView;

import lombok.Setter;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class FileSave {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(BRTJsonView.FileSave.class)
	Long file_id;

	@JsonView(BRTJsonView.FileSaveCommon.class)
	String file_name;

	@JsonView(BRTJsonView.FileSaveCommon.class)
	String file_path;

	@JsonView(BRTJsonView.FileSaveCommon.class)
	String save_file_name;

	@JsonView(BRTJsonView.FileSaveCommon.class)
	String save_file_path;

	@JsonView(BRTJsonView.FileSaveCommon.class)
	String file_type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "work_id")
	Works works;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "eval_item_id")
	Evaluation_item eval_item;


}
