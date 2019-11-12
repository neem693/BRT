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

@Entity
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

	public Long getFile_id() {
		return file_id;
	}

	public void setFile_id(Long file_id) {
		this.file_id = file_id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getSave_file_name() {
		return save_file_name;
	}

	public void setSave_file_name(String save_file_name) {
		this.save_file_name = save_file_name;
	}

	public String getSave_file_path() {
		return save_file_path;
	}

	public void setSave_file_path(String save_file_path) {
		this.save_file_path = save_file_path;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public Works getWorks() {
		return works;
	}

	public void setWorks(Works works) {
		this.works = works;
	}

}
