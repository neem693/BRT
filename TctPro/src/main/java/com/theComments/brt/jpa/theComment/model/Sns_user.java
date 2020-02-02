package com.theComments.brt.jpa.theComment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sns_user {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long sns_id; 
	
	@Column(length = 510)
	String access_token;
	
	String sns_user_unique_id;
	
	String sns_type;
	
	String sns_email;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	Eva_user eva_user;	
	

}
