package consumer;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

public class IteratingEntriesOfMap {
	
	public static void main(String[] args) {
		
		Map<String,Object> ages = new HashMap<>();
		ages.put("John", 25);
		ages.put("Freddy", 24);
		ages.put("Samuel", 30);
		
		ages.forEach((name,age) -> System.out.println(name + " is " + age + " years old."));
		
	}

}
