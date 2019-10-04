package com.framework.Tct.test.controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.action.internal.EntityIdentityInsertAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.framework.Tct.jpa.Jpa1.dao.JpaUserRepository;
import com.framework.Tct.jpa.Jpa1.model.JpaUser;

@RestController
@RequestMapping("/test")
public class JpaTest {
	


	
	@Autowired
	private JpaUserRepository userRepo;
	
	@Autowired
	@Qualifier("emFac1")
	private EntityManagerFactory emFac;
	
	@RequestMapping(value = "/jpatest", method = RequestMethod.GET)
	@Transactional("userTransactionManager")
	public void jpaTest() {
		
		System.out.println("wefwewefeffw TEST");
		
		JpaUser user = new JpaUser();
		user.setAge(28);
		user.setEmail("John@tes2t.com");
		user.setName("John");
		user = userRepo.save(user);
		
		System.out.println(user);
	}
	@RequestMapping(value = "/jpaGet", method = RequestMethod.GET)
	public List<JpaUser> listJPATest() {
		
		
		
		EntityManager em =  emFac.createEntityManager();
		
		return userRepo.findAll();
		
	}
	
	


}
