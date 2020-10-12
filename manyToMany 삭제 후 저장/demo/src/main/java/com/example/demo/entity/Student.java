package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(exclude="registration")
@ToString(callSuper = false, exclude = {"registration"})
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	String name;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	Set<Registration> registration;
	
	
	
	
	

}
