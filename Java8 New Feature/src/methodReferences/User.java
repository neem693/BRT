package methodReferences;

import lombok.Data;

@Data
public class User {
	
	public User() {
		// TODO Auto-generated constructor stub
		
	}
	
	public User(User user) {
		this();
		
	}
	
	Address address;


	public static Boolean isRealUser(User user) {
		
		return true;
		
	}
	
	public boolean isLegalName (String str) {
		
		return true;
		
	}
	
	

	
	
	

}
