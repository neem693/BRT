package suppliers;

import java.util.Arrays;
import java.util.stream.Stream;

public class SequenceGeneration {
	
	public static void main(String[] args) {
		
		int [] fibs = {1, 2};
		Stream<Integer> fibonacci = Stream.generate(() -> {
			int result = fibs[1];
			int fib3 = fibs[0] + fibs[1];
			fibs[0] = fibs[1];
			fibs[1] = fib3;
			return result;
		});
		
		System.out.println(fibonacci.findFirst().get());
		
		
		for(int i =0; i< fibs.length; i++) {
			System.out.println(i + " : " +fibs[i]);
		}
		
	}

}
