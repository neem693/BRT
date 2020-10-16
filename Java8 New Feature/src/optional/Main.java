package optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import methodReferences.Address;
import methodReferences.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//part1
		Optional<String> optional = Optional.empty();
		
		String str = "value";
		Optional<String> optional1 = Optional.of(str);
		
		Optional<String> optional2 = Optional.ofNullable(null);
		
		System.out.println(optional);
		System.out.println(optional1);
		System.out.println(optional2);
		
		
		//part2
		List<String> list = getList();
		List<String> listOpt = list != null ? list : new ArrayList<String>();
		
		List<String> listOpt1 = getOptionalList().orElseGet(() -> new ArrayList<>());
		
		
//		List<String> list = 
		
		//part3
		
		Address address = new Address();
		address.setStreet("eeeeeStreet");
		User user = new User();
		
		user.setAddress(address);
		
		System.out.println(getAddressWithOldWay(user));
		
		
		
		
		
		
		
	}
	
	public static List<String> getList(){
		
		List<String> list = Arrays.asList("aaa","bbb","ccc");
		return list;
		
	}
	
	public static Optional<List> getOptionalList(){
		
		return Optional.of(getList());
	}
	
	public static String getAddressWithOldWay (User user) {
		if (user != null) {
		    Address address = user.getAddress();
		    if (address != null) {
		        String street = address.getStreet();
		        if (street != null) {
		            return street;
		        }
		    }
		}
		return "not specified";
	}
	
	public static String getAddressWithOptionalWay (User user) {
		Optional<User> userOptional = Optional.ofNullable(user);
		String result = userOptional
				.map(User::getAddress)
				.map(Address::getStreet)
				.orElse("not specified");
		
		return result;
		
	}
	
	
	
	

}
