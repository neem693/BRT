package com.theComments.brt.jpa.dto;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.theComments.brt.jpa.theComment.model.Type2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Type1Dto {

	Long type1_id;
	String type1_name;
	List<Type2Dto> type2Dto;
	
	
	
	

}
