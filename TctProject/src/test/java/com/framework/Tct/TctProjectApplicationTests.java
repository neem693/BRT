package com.framework.Tct;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest
@ActiveProfiles("test1")
@RunWith(SpringJUnit4ClassRunner.class)
public class TctProjectApplicationTests {
	
	@Autowired
	private MockitoServiceWork mokitoWork;
	@Autowired
	private MockitoService service;
	
	@Test
	public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
		
		Mockito.when(service.getMockitoService()).thenReturn("Mock Name");
		String testName = mokitoWork.getMockitoWorkString();
		Assert.assertEquals("Mock Name", testName);
		
	}

	@Test
	public void contextLoads() {

	}

}
