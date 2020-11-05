package function;

import java.util.HashMap;
import java.util.Map;

public class Function {
	public static void main(String[] args) {
		Map<String, Integer> nameMap = new HashMap<>();
		Integer value = nameMap.computeIfAbsent("John", s -> s.length());
		System.out.println(value);
		
		value = nameMap.computeIfAbsent("John1", String::length);
		System.out.println(value);
		System.out.println(nameMap);
	}
}
