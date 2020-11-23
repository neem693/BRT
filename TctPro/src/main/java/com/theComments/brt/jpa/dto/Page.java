package com.theComments.brt.jpa.dto;

import javax.persistence.Transient;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Page {
	
	@Transient
	int pageNum;

	@Transient
	int pageSize;

	@Transient
	long totalSize;

	@Transient
	String searchText;

}
