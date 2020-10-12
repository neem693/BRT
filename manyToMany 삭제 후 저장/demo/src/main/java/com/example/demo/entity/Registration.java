package com.example.demo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(exclude= {"student","course"})
@ToString(callSuper = false,exclude= {"student","course"})
public class Registration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	Student student;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Course course;
	
	Date rgtm;
	
	int grade;
	
	

}
