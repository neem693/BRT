package com.framework.Tct.batchService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {
	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
	private final JdbcTemplate jdbcTemplate;
	
	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!!! JOB FINISHED !! It's time to verify the results!!");
			
			List<User2> results = jdbcTemplate.query("SELECT first_name, last_name FROM USERS2", new RowMapper<User2>() {
				@Override
				public User2 mapRow(ResultSet rs, int row) throws SQLException {
					// TODO Auto-generated method stub
					return new User2(rs.getString(1),rs.getString(2));
				}
			});
			
			for(User2 person : results) {
				log.info("Found <" + person + "> in the database.");
			}
			
		}
		
	}
	
	
	
	
	

}
