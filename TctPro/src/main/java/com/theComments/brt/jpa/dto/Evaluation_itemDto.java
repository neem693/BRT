package com.theComments.brt.jpa.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Evaluation_itemDto {


	Long eval_item_id;
	String subjectMatter;
	String ev_text1;
	String ev_text2;
	Integer ev_value;
	String donation;
	List<EvaluateDto> evaluate;
	Integer yellow;
	Integer black;
	Integer blue;
	Integer gray;
	
	public Evaluation_itemDto(String subjectMatter, Integer yellow, Integer black, Integer blue, Integer gray) {
		super();
		this.subjectMatter = subjectMatter;
		this.yellow = yellow;
		this.black = black;
		this.blue = blue;
		this.gray = gray;
	}
	
	
	
}
