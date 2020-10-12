package com.example.demo.entity.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Registration;
import com.example.demo.entity.Student;

@Repository
public interface RegistrationDao extends JpaRepository<Registration, Long> {

	Set<Registration> findByStudent(Student student);

}
