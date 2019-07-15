package com.framework.Tct.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class Test {
	private static Map<String,Object> test;
	static{
		test = new HashMap<String,Object>();
		
		test.put("one", "일");
		test.put("two", "이");
		
	}
	
	@RequestMapping(value = "/get")
	public String getGet() {
		
		test.put("three","get");
		
		return test.toString();
		
	}
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String getPost(@RequestBody String body) {
		
		test.put("three",body);
		
		return test.toString();
		
	}
	@RequestMapping(value = "/put",method = RequestMethod.PUT)
	public String getPut(@RequestBody String body) {
		
		test.put("three",body);
		
		return test.toString();
		
	}
	@RequestMapping(value = "/delete",method = RequestMethod.DELETE)
	public String getDelete(@RequestParam Map<String,Object> param) {
		
		test.put("three",param);
		
		return test.toString();
		
	}

}
