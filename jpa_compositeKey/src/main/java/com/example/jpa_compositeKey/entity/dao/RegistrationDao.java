package com.example.jpa_compositeKey.entity.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa_compositeKey.entity.Student;
import com.example.jpa_compositeKey.entity.registration.Registration;

@Repository
public interface RegistrationDao extends JpaRepository<Registration, Long> {

	Set<Registration> findByStudent(Student student);

}
