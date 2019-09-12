package com.framework.Tct.unitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


public class TestServiceControllerUnitTest extends AbstractTest{
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void getTest() throws Exception {
		String uri = "/test/get";
		MvcResult mvcResult = mvc
							.perform(MockMvcRequestBuilders.get(uri)
							.accept(MediaType.APPLICATION_JSON_VALUE))
							.andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Map<String,Object> result = super.mapFromJson(content, HashMap.class);
		assertTrue(result != null);
		
	}
	
	@Test
	public void postTest() throws Exception {
		String uri = "/test/post";
		
		Map<String,Object> map = new HashMap<>();
		map.put("body", "Ginger");
		
		String inputJson = super.mapToJson(map);
		
		MvcResult mvcResult = mvc
							.perform(MockMvcRequestBuilders
							.post(uri)
							.contentType(MediaType.APPLICATION_JSON_VALUE)
							.content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Map<String,Object> result = super.mapFromJson(content, HashMap.class);
		assertTrue(result != null);
							
	}
	
	@Test
	public void putTest() throws Exception {
		String uri = "/test/put";
		
		Map<String,Object> map = new HashMap<>();
		map.put("body", "Ginger");
		
		String inputJson = super.mapToJson(map);
		
		MvcResult mvcResult = mvc
							.perform(MockMvcRequestBuilders
							.put(uri)
							.contentType(MediaType.APPLICATION_JSON_VALUE)
							.content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Map<String,Object> result = super.mapFromJson(content, HashMap.class);
		assertTrue(result != null);
							
	}
	
	@Test
	public void deleteTest() throws Exception {
		String uri = "/test/delete";
		
		Map<String,Object> map = new HashMap<>();
		map.put("body", "Ginger");
		
		String inputJson = super.mapToJson(map);
		
		MvcResult mvcResult = mvc
							.perform(MockMvcRequestBuilders
							.delete(uri))
							.andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertTrue(content != null);
							
	}

	

}
