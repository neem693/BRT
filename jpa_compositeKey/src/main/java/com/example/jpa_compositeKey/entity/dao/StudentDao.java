package com.example.jpa_compositeKey.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa_compositeKey.entity.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {
	
	

}
