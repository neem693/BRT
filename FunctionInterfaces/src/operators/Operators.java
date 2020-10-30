package operators;

import java.util.Arrays;
import java.util.List;

public class Operators {
	
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("bob","josh","megan");
		names.replaceAll(name -> name.toUpperCase());
		//is same
		names.replaceAll(String::toUpperCase);
		System.out.println(names);
		
		//reduce
		List<Integer> values = Arrays.asList(3,5,8,9,12);
		int sum = values.stream().reduce(0, (i1,i2) -> i1 + i2);
		
		
	}

}
