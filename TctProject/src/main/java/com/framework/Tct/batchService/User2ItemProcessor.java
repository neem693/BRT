package com.framework.Tct.batchService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class User2ItemProcessor implements ItemProcessor<User2, User2> {
	
	private static final Logger log = LoggerFactory.getLogger(User2ItemProcessor.class);

	@Override
	public User2 process(final User2 user ) throws Exception {
		// TODO Auto-generated method stub
		final String firstName = user.getFirstName().toUpperCase();
		final String lastName = user.getLastName().toUpperCase();
		final User2 transformedPerson = new User2(firstName,lastName);
		
		log.info("Converting (" + user + ") into (" + transformedPerson + ")");
		
		return transformedPerson;
	}

}
