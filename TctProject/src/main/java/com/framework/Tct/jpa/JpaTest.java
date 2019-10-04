package com.framework.Tct.jpa;

import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.framework.Tct.jpa.Jpa1.dao.JpaUserRepository;
import com.framework.Tct.jpa.Jpa1.model.JpaUser;

@RunWith(SpringJUnit4ClassRunner.class)
public class JpaTest {
	
	@Autowired
	private JpaUserRepository userRepo;
	
	@Test
	@Transactional("userTransactionManager")
	public void whenCreatingUser_thenCreate() {
		
		System.out.println("wefwewefeffw TEST");
		
		JpaUser user = new JpaUser();
		user.setAge(28);
		user.setEmail("John@test.com");
		user.setName("John");
		user = userRepo.save(user);
		
		assertNotNull(userRepo.findById(user.getId()));
	}

}
