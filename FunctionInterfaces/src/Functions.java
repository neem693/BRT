import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Functions {
	
	public static void main(String[] args) {
		
		Map<String,Integer> nameMap = new HashMap<>();
		Integer value = nameMap.computeIfAbsent("john", s -> s.length());
//we may replace the lambda with a method reference that matches passed and returned value types.
		
		System.out.println(value);
		
		Function<Integer,String> intToString = Object::toString;
		Function<String, String> quote = s-> "'" + s + "'";
		Function<Integer, String> quoteIntToString = quote.compose(intToString);
		
		System.out.println(quoteIntToString.apply(5));
		
	}

}
