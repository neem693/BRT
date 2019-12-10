package com.theComments.brt.jpa.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Evaluation_itemDto extends Page{


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
	
	//dynamicQuery용
	String subject;
	LocalDateTime create_date;
	LocalDateTime create_end_date2;
	
	String art_name;
	String type2_name;
	String type1_name;
	
	//querydsl 용
	String art_name_List;
	
	
	
	public Evaluation_itemDto(String subjectMatter, Integer yellow, Integer black, Integer blue, Integer gray) {
		super();
		this.subjectMatter = subjectMatter;
		this.yellow = yellow;
		this.black = black;
		this.blue = blue;
		this.gray = gray;
	}
	
	public Evaluation_itemDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
