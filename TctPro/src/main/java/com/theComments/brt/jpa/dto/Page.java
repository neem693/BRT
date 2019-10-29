package com.theComments.brt.jpa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Page {
	
	int pageNum;
	int pageSize;
	long totalSize;
	String searchText;

}
