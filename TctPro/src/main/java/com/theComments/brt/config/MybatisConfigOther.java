package com.theComments.brt.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import javax.annotation.Resources;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class MybatisConfigOther {

	@Autowired
	@Qualifier("primaryDataSource")
	HikariDataSource datasource;

	@Primary
	@Bean
	@Qualifier("primaryMybatis")
	public SqlSessionFactory mybatisConfig() throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(datasource);
		sqlSessionFactoryBean.setVfs(SpringBootVFS.class);

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resolver.getResources("classpath:mapper/*.xml");

		sqlSessionFactoryBean.setMapperLocations(resources);

		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();

		return sqlSessionFactory;
	}
}
