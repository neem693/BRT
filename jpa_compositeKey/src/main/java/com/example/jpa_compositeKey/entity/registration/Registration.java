package com.example.jpa_compositeKey.entity.registration;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.example.jpa_compositeKey.entity.Course;
import com.example.jpa_compositeKey.entity.Student;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(exclude= {"student","course"})
@ToString(callSuper = false,exclude= {"student","course"})
public class Registration {
	
	@EmbeddedId
	CourseRatingKey id;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@MapsId("studentId")
	Student student;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("courseId")
	Course course;
	
	Date rgtm;
	
	int grade;
	
	

}
