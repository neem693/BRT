package com.theComments.brt.jpa.dto;

import javax.persistence.Transient;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class OrderForSearch {
	
	@Transient
	int order;
	@Transient
	int order2;
	@Transient
	int order3;

}
