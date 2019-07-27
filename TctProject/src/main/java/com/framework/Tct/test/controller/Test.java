package com.framework.Tct.test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.framework.Tct.exception.ExceptionTct;
import com.framework.Tct.test.service.TestService;

@RestController
@RequestMapping(value = "/test")
@CrossOrigin(origins = "http://127.0.0.1:4200")
public class Test {
	
	@Autowired
	public TestService testService;
	
	
	
	@RequestMapping(value = "/get")
	public Map<String,Object> getGet() {
		
		Map<String,Object> result = testService.get();
		
		return result;
		
	}	
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public Map<String,Object> getPost(@RequestBody String body) {
		
		Map<String,Object> result = testService.post(body);
		
		return result;
		
	}
	
	@RequestMapping(value = "/put",method = RequestMethod.PUT)
	public Map<String,Object> getPut(@RequestBody String body) {
		
		Map<String,Object> result = testService.put();
		
		return result;
		
	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.DELETE)
	public String getDelete(@RequestParam Map<String,Object> param) {
		
		Map<String,Object> result = testService.delete();
		
		return result.toString();
		
	}
	
	@RequestMapping(value = "/getParam")
	public String getGetParam(@RequestParam Map<String,Object> parameter) {
		
		String result = testService.getGetParam(parameter);
		
		return result;
		
	}
	
	@RequestMapping(value = "/interCeptorTest")
	public String interCeptorTest(@RequestParam Map<String,Object> parameter) {
		System.out.println("현재 테스트");
		return null;
		
	}
	
	@RequestMapping(value = "/restGet")
	public Map<String,Object> restGet(@RequestParam Map<String,Object> parameter){
		
		Map<String,Object> result = testService.restGet(parameter);
	
		return result;
		
	}
	
	@RequestMapping(value = "/restPost", method = RequestMethod.POST)
	public Map<String,Object> restPost(@RequestBody Map<String,Object> parameter){
		
		Map<String,Object> result = testService.restPost(parameter);
		return result;
		
	}
	
	@RequestMapping(value = "/restDelete", method = RequestMethod.DELETE)
	public String restDelete(@RequestParam Map<String,Object> parameter){
		
		
		String result = testService.restDelete(parameter);
		
		return result;
		
	}
	
	@RequestMapping(value = "/restPut",method = RequestMethod.PUT)
	public Map<String,Object> restPut(@RequestBody Map<String,Object> parameter){
		
		Map<String,Object> result = testService.restPut(parameter);
		
		return result;
		
	}
	
	@RequestMapping(value = "/upload",method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String fileUpload(@RequestParam("file") MultipartFile[] file) throws IOException {
		
		for(int i =0; i<file.length; i++) {
			
			MultipartFile one = file[i];
			
			File backFolder = new File("/tempTctData");
			backFolder = backFolder.getCanonicalFile();
			backFolder.mkdirs();
			
			File convertFile = new File("/tempTctData/" + one.getOriginalFilename());
			convertFile = convertFile.getCanonicalFile();
			convertFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(convertFile);
			fout.write(one.getBytes());
			fout.close();
			
			
		}
		return "FIle is upload successfully";
		
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<Object> downloadFile(@RequestParam(required = true,name = "fileName") String fileName) throws IOException{
		
		//String fileName = parameter.get("fileName").toString();
		File file = new File("/tempTctData/" + fileName);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"",fileName));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragam", "no-cache");
		headers.add("Expires", "0");
		
		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);
		
		return responseEntity;
		
		
	}

}
