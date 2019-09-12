package com.framework.Tct.redis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
	
	@Autowired
	RedisTemplate<String, Object> redis;
	
	@RequestMapping("redisRequesting")
	public String excuteRedisInMem() {
		Map<Object,Object> datalist = redis.opsForHash().entries("111");
		return datalist.toString();
	}
	
	@RequestMapping("redisPutRequest")
	public String redisPutRequest() {
		redis.opsForHash().put("111", "eee", "efef");
		return "success";
	}

}
