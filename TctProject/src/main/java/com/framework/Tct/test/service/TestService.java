package com.framework.Tct.test.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.framework.Tct.exception.ExceptionTct;

@Service
public class TestService {
private static Map<String,Object> test;
	
	@Autowired
	RestTemplate restTemplate;
	
	static{
		test = new HashMap<String,Object>();
		
		test.put("one", "일");
		test.put("two", "이");
		
	}

	public Map<String, Object> get() {
		// TODO Auto-generated method stub
		
		test.put("three", "get");
		
		return test;
	}

	public Map<String, Object> post(String body) {
		// TODO Auto-generated method stub
		
		test.put("three", body);
		return test;
	}

	public Map<String, Object> put() {
		// TODO Auto-generated method stub
		
		test.put("three", "put");
		
		return test;
	}

	public Map<String, Object> delete() {
		// TODO Auto-generated method stub
		test.put("three", "delete");
		
		return test;
	}

	public String getGetParam(Map<String, Object> parameter) {
		// TODO Auto-generated method stub
		if(parameter.containsKey("key") == false)
		{
			throw new ExceptionTct();
		}
		
		String key = parameter.get("key").toString();
		
		if(test.containsKey(key) == false) {
			throw new ExceptionTct(test);
		}
	
		
		
		return test.get(key).toString();
	}

	public Map<String, Object> restGet(Map<String, Object> parameter) {
		// TODO Auto-generated method stub
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String,Object>> httpEntity = new HttpEntity<Map<String,Object>>(header);
		Map<String,Object> result = restTemplate.exchange("http://127.0.0.1:8081/TctPro/test/get", HttpMethod.GET, httpEntity, Map.class).getBody();
		
		return result;
	}

	public Map<String, Object> restPost(Map<String, Object> parameter) {
		// TODO Auto-generated method stub
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String,Object>> httpEntity = new HttpEntity<Map<String,Object>>(parameter,header);
		Map<String,Object> result = restTemplate.exchange("http://127.0.0.1:8081/TctPro/test/post", HttpMethod.POST, httpEntity, Map.class).getBody();
		
		return result;
	}

	public String restDelete(Map<String, Object> parameter) {
		// TODO Auto-generated method stub
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String,Object>> httpEntity = new HttpEntity<Map<String,Object>>(header);
		String result = restTemplate.exchange("http://127.0.0.1:8081/TctPro/test/delete", HttpMethod.DELETE, httpEntity, String.class).getBody();
		return result;
	}

	public Map<String, Object> restPut(Map<String, Object> parameter) {
		// TODO Auto-generated method stub
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String,Object>> httpEntity = new HttpEntity<Map<String,Object>>(parameter,header);
		Map<String,Object> result = restTemplate.exchange("http://127.0.0.1:8081/TctPro/test/put", HttpMethod.PUT, httpEntity, Map.class).getBody();
		return result;
	}
	
	
	
}
