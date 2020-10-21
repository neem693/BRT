import java.util.HashMap;
import java.util.Map;

public class TwoArityFunctionSpecialization {
	
	public static void main(String[] args) {
				
		Map<String,Integer> salaries = new HashMap<>();
		salaries.put("Jone", 40000);
		salaries.put("Freddy", 30000);
		salaries.put("Samuel", 50000);
		
		salaries.replaceAll((name, oldValue) -> name.equals("Freddy") ? oldValue : oldValue + 10000);
		
		System.out.println(salaries);
		
	}

}
