package com.framework.Tct.oAuth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter  {
	
	@Autowired
	PasswordEncoder encoder;
	
	private String clinetId = "TctTest";
	private String clientSeceret = "12341234aa";
	private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpAIBAAKCAQEA2qQGJcfx1pC3zRmfTxzQk+FBZlqrlLJrZr0rTKyTJxbxDNA7\r\n" + 
			"uUxXTerRFlwEJZAClFvrAW/5zDkZ5bn3hvuFzqWrEIQVx+UzmuOL8EiLzhG47PWF\r\n" + 
			"zCUCYqjLPFQg9HO5ZdOWBZQVM/ntEO5iwvpWKUzO9BWuPuSxGQUQ1NqQqZKctakF\r\n" + 
			"RiroL0BVJu3uqWSTRhFquH6enN6g6Eqv14uuJIWj6rBeEuWXkTSq7prmCDor86Cy\r\n" + 
			"1HU9FSIYkhdsXc8xe2spat5W12b3DxiuzHW6cFBrVn1GZcfsYyqyRJzAC94/3fEJ\r\n" + 
			"OAXqjiMWC+X81jbulRvfSFp5KOK2dchPXqU8SQIDAQABAoIBAQCzbX5aDQ9LrbIZ\r\n" + 
			"EFjr3NLTOT2pmOlMe2umgcICB3Iv1yT1BgKtW5geKoFynwsMJHXpeNGQeWt/jLDT\r\n" + 
			"FV2smcfCwbR0NmGFjXRfPTP/ehm5gFPJquglk420l59KICR3WG0iwpRQeak44XcK\r\n" + 
			"uQe1ySlidVU1fIFlvdoUlVKty7yCW3mia9heKIn+3nH4trcZsES1wkoiSov11fKq\r\n" + 
			"iYvcwoGuDK7bUhYMdY5Ef5ZiEfoPJP4xkiNtN0LB4mm92UUT2s1juh7TApF7j6CT\r\n" + 
			"PE/Ghn/1PyiLG74V5q2jMuSucNJ+0UhYPfCG5xN162VkacvTOqC2QJyLElcJeIWk\r\n" + 
			"TivTJm6BAoGBAPfWxzNZ+MrVTP+AbiUl+NXHVVdkR23mgV+aqoXxKHd+6kpVG213\r\n" + 
			"DCu16VCjuQheEvUNAEmpZ+UtxjjWRBxeM00atzjdq71yLjfVCn75EZa5Uxw9ufEl\r\n" + 
			"ScU7mkW6b8Mp1Ma1YpzgCrSs0VM+KXtFD3DQVbGqvLz1LaLF6DDxsopRAoGBAOHX\r\n" + 
			"HJnCzLR2AgKPtd1qzkqYsesf1bKM29FOVD8jFDFbJYA0syANdHh3GsTwYZY5JOZI\r\n" + 
			"+mpI+WFv49/sP13alldHSGNHLZlXqQgYpEUqPkDf/Y1/UVovUf9yxH4lGPfW1o0q\r\n" + 
			"mgsMRwiPvGURh78hiu9KxbyKsQRR1HLbTPZO0Rx5AoGBAKfPtsuvdQUqDlvGQ05F\r\n" + 
			"+soNkVx+GttwQ1NPr3zIAIWA2vT/0XV6MTR7lQI0CXp/8EgayIIYAbAtIVWkxzOK\r\n" + 
			"GSRxHXSUq8+3u1G0n8m/rcgnrf2mUfvVKrEwnVHvXfOApIDzmlTsYnNZvNandYDx\r\n" + 
			"DvZtKkkFeYxcWs0nQgO59BExAoGAJC0TFcZQiC/HDqX6mec7+FMRXPqSfrF1nMeR\r\n" + 
			"UzPJTkatcSX/84h0Ob/Kd/WRjEDHGmRiSJg76lHEDOCJHf2fy4dNnymNslyKZROd\r\n" + 
			"bL7hjf7TXNEiNPITjnnR4+sJXtn5ME+8sTxcPJDZus7eEc3LtZ0io5sL1AdPor5i\r\n" + 
			"S6pAcPECgYBTxOvMexGUpwGdAxKv+BFu+0H6c1m3E/8a0RvzY5w07gyIvF5yj0Z9\r\n" + 
			"sxNa405ZznUuS76EtszGXBiPT1TYh8QcnACRwAzckoFFLVa1vleZUM+h9TLabU3J\r\n" + 
			"IxAqiq4fLUp4Nxw3YUvSeOGQXCyboY5uWf0bjKM/QGdfWgMaqOcfmQ==\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	private String publicKey = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2qQGJcfx1pC3zRmfTxzQ\r\n" + 
			"k+FBZlqrlLJrZr0rTKyTJxbxDNA7uUxXTerRFlwEJZAClFvrAW/5zDkZ5bn3hvuF\r\n" + 
			"zqWrEIQVx+UzmuOL8EiLzhG47PWFzCUCYqjLPFQg9HO5ZdOWBZQVM/ntEO5iwvpW\r\n" + 
			"KUzO9BWuPuSxGQUQ1NqQqZKctakFRiroL0BVJu3uqWSTRhFquH6enN6g6Eqv14uu\r\n" + 
			"JIWj6rBeEuWXkTSq7prmCDor86Cy1HU9FSIYkhdsXc8xe2spat5W12b3DxiuzHW6\r\n" + 
			"cFBrVn1GZcfsYyqyRJzAC94/3fEJOAXqjiMWC+X81jbulRvfSFp5KOK2dchPXqU8\r\n" + 
			"SQIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";
	
	private int tokenValidSec = 20000;
	private int refreshTokenValidSec = 20000;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Bean
	public JwtAccessTokenConverter tokenEnhancer() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(privateKey);
		converter.setVerifierKey(publicKey);
		return converter;
	}
	
	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(tokenEnhancer());
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(endpoints);
		endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore()).accessTokenConverter(tokenEnhancer());
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(security);
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(clients);
		System.out.println("passsssssssssssssssssssssssssssssssssss");
		System.out.println(encoder.encode(clientSeceret));
		clients.inMemory().withClient(clinetId).secret(encoder.encode(clientSeceret)).scopes("read","write")
		.authorizedGrantTypes("password","refresh_token").accessTokenValiditySeconds(tokenValidSec)
		.refreshTokenValiditySeconds(refreshTokenValidSec);
	}
	
	

}
