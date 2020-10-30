package consumer;

import java.util.Arrays;
import java.util.List;

public class Consumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> names = Arrays.asList("John","Freddy","Samuel");
		names.forEach(name -> System.out.println("Heelo , " + name));
		
	}

}
