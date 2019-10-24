package com.theComments.brt.jpa.dto;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.theComments.brt.jpa.theComment.model.Type1;
import com.theComments.brt.jpa.theComment.model.Works;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Type2Dto {
	
	Long type2_id;
	String type2_name;
	Type1Dto type1Dto;
}
