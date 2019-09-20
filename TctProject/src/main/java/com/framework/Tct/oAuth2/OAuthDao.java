package com.framework.Tct.oAuth2;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

@Repository
public class OAuthDao {

	@Autowired
	@Qualifier("getPrimaryTemplate")
	JdbcTemplate primaryJdbcTemplate;
	
	public UserEntity getUserDetails(String username) {
		
		Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
		String userSqlQuery = "SELECT * FROM OAUTH2 WHERE USERNAME=?";
		List<UserEntity> list = primaryJdbcTemplate
								.query(userSqlQuery
										,new String[] { username }
										,(ResultSet rs, int rowNum) ->{
											UserEntity user = new UserEntity();
											user.setUsername(username);
											user.setPassword(rs.getString("PASSWORD"));
											return user;
										});
		
		if(list.size() > 0){
			
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
			grantedAuthoritiesList.add(grantedAuthority);
			list.get(0).setGrantedAuthoritiesList(grantedAuthoritiesList);
			return list.get(0);
			
		}
		return null;
		
	}

}
