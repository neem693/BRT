package com.theComments.brt.jpa.dto;

import javax.persistence.Transient;

import lombok.Data;

@Data
public class PageAndSort {
	
	@Transient
	Integer pageNum;

	@Transient
	Integer pageSize;

	@Transient
	Long totalSize;

	@Transient
	String searchText;
	
	
	@Transient
	Integer order;
	@Transient
	Integer order2;
	@Transient
	Integer order3;
	
	@Transient
	Long type1;
	
	@Transient
	Long type2;
	

}
