package methodReferences;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
	
	public static void main(String[] args) {
		
		List<User> list = new ArrayList<>();
		List<String> list_str = new ArrayList<>();
		
		boolean isReal = list.stream().anyMatch(u -> User.isRealUser(u));
		
		System.out.println(isReal);
		
		boolean isReal_ = list.stream().anyMatch(User::isRealUser);
		
		User user = new User();
		boolean isLegalName = list_str.stream().anyMatch(user::isLegalName);
		
		long count = list_str.stream().filter(String::isEmpty).count();
		
		Stream<User> stream = list.stream().map(User::new);
		
		
		
		
		
		
		
		
	}

}
