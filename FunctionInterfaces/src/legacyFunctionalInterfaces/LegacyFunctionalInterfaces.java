package legacyFunctionalInterfaces;

public class LegacyFunctionalInterfaces {
	
	public static void main(String[] args) {
		
		Thread thread = new Thread(() -> System.out.println("Hello From Another Thread"));
		thread.start();
		
	}

}
