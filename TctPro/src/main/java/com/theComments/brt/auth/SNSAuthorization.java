package com.theComments.brt.auth;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theComments.brt.constFile.SNS;

@Component
public class SNSAuthorization {
	

	@Autowired
	private RestTemplate restTemplate;
	
	public Map<String, Object> oAuth2TokenApi(String snsType,String access_token) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		Map<String,Object> resultMap = new HashMap<String, Object>();
		
		String result = "";
		
		if(snsType.equals(SNS.GOOGLE.snsType)) {
			headers.set("Authorization", "Bearer " + access_token);
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			ResponseEntity<String> response = restTemplate.exchange(SNS.GOOGLE.checkAccessTokenUri, HttpMethod.GET, entity, String.class);
			result = response.getBody();
		}else if(snsType.equals(SNS.KAKAO.snsType)) {
			headers.set("Authorization", "Bearer " + access_token);
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			ResponseEntity<String> response = restTemplate.exchange(SNS.KAKAO.checkAccessTokenUri, HttpMethod.GET, entity, String.class);
			result = response.getBody();
		}

		
		
		try {
			resultMap = new ObjectMapper().readValue(result, HashMap.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultMap; 
	}

}
