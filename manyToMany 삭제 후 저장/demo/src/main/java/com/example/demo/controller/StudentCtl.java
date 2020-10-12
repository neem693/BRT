package com.example.demo.controller;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Registration;
import com.example.demo.entity.Student;
import com.example.demo.entity.dao.RegistrationDao;
import com.example.demo.entity.dao.StudentDao;

@RestController
@RequestMapping("/student")
public class StudentCtl {
	
	@Autowired
	StudentDao dao;
	
	@Autowired
	RegistrationDao regiDao;
	
	@GetMapping("/test")
	public Integer test() {
		return 1;
	}
	
	@PostMapping
	public void post(@RequestBody Student student) {
		
		//삭제 후 
		Set<Registration> savedRegiSet = regiDao.findByStudent(student);
		Set<Registration> regiSet = student.getRegistration();
		
		for(Registration r : regiSet) {
			savedRegiSet.removeIf(x -> x.getId() == r.getId() );
		}
		
		regiDao.deleteAll(savedRegiSet);

		
		//저장
		if(ObjectUtils.isEmpty(student.getRegistration()) == false) {
			
		
		student.getRegistration().forEach(x -> {
			x.setStudent(student);
			x.setRgtm(new Date());
		});
		

		

		}

		Student savedStudent = dao.save(student);

		
		
		
	}
	

}
