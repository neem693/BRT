package com.framework.Tct.jdbcTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempalateSimpleExample {
	
	@Autowired
	@Qualifier("getPrimaryTemplate")
	private JdbcTemplate primaryJdbcTemplate;
	
	@RequestMapping("getTemplateCollection")
	public List<Map<String,Object>> templateExample(){
		return primaryJdbcTemplate.queryForList("SELECT * FROM flyway_schema_history");
	}

}
