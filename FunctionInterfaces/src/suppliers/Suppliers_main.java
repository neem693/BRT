package suppliers;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import com.google.common.util.concurrent.Uninterruptibles;

public class Suppliers_main {
	
	
	static Supplier<Double> lazyValue = () -> {
		Uninterruptibles.sleepUninterruptibly(1000,TimeUnit.MILLISECONDS);
		return 9d;
	};
	
	public static Double squareLazy(Supplier<Double> lazyValue) {
		return Math.pow(lazyValue.get(), 2);
	}
	
	public static void main(String[] args) {
		
		System.out.println(squareLazy(lazyValue));
		
	}

}
