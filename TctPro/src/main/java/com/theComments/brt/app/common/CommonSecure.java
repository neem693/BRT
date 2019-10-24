package com.theComments.brt.app.common;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theComments.brt.jpa.dto.SimpleUserDto;

public class CommonSecure {
	
	static final String RANDOM_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789";
	
	public static String getRandomSecure(int length) {
		if(length ==0) {
			return null;
		}
		SecureRandom random = new SecureRandom();
		char [] char_array = new char[length];
		for(int i =0; i<length;i++) {
			char_array[i] = RANDOM_CHAR.charAt(random.nextInt(RANDOM_CHAR.length()));
		}
		
		return new String(char_array);
	}
	
	public static LocalDateTime getDateTime(long unix) {
		
		return LocalDateTime.ofInstant(Instant.ofEpochSecond(unix), TimeZone.getDefault().toZoneId());
		
	}
	
	public static SimpleUserDto getSimpleUserDto(HttpServletRequest request) {
		
		String tokenKey = request.getHeader("AUthorization");
		String payload = tokenKey.split("\\.")[1];
		payload = new String(Base64.getDecoder().decode(payload));
		Map result = null;
		try {
			result = new ObjectMapper().readValue(payload, HashMap.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String user_name = result.get("user_name").toString();
		Long userId = Long.parseLong(result.get("userId").toString());
		List<String> authorities = (List<String>)result.get("authorities");
		
		SimpleUserDto userDto = new SimpleUserDto();
		userDto.setUser_name(user_name);
		userDto.setUserId(userId);
		userDto.setAuthorities(authorities);
		
		return userDto;
	}

}
