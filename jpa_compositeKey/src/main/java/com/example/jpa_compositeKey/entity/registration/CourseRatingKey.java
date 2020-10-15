package com.example.jpa_compositeKey.entity.registration;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class CourseRatingKey implements Serializable{
	
	@Column
	Long studentId;
	
	@Column
	Long courseId;
	
	

}
