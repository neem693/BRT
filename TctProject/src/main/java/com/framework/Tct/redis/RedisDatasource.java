package com.framework.Tct.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisDatasource {
	
	@Bean
	public LettuceConnectionFactory  lettuceConnectionFactory() {
		
		RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration("localhost",6000);
//		JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
//		return jedisConFactory;
		LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisConfig);
		return lettuceConnectionFactory;
	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(){
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(lettuceConnectionFactory());
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(new StringRedisSerializer());
		template.setValueSerializer(new StringRedisSerializer());
		return template;
	}

}
