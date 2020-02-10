package com.theComments.brt.jpa.theComment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Email_template {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long email_template_id;
	
	@Column(columnDefinition="TEXT")
	String template_text;
	
	String template_subject;
	

}
