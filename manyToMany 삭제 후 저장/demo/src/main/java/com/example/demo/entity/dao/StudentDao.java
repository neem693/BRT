package com.example.demo.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {
	
	

}
