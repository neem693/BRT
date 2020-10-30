package pridicates;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Predicates {
	
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Angela","Aaron","Bob","Claire","David");
		
		List<String> nameWithA = names.stream()
				.filter(name -> name.startsWith("A"))
				.collect(Collectors.toList());
		
		System.out.println(nameWithA);
	}

}
