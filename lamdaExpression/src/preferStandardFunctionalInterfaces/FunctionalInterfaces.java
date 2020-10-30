package preferStandardFunctionalInterfaces;

import java.util.function.Function;

public class FunctionalInterfaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UseFoo useFoo = new UseFoo();
		
		Foo foo = parameter -> parameter + " from lambda";
		String result = useFoo.add("Message ", foo);
		System.out.println(result);
		
		Function<String,String> fn = parameter -> parameter + " from lambda";
		String result1 = useFoo.add("Message ", fn);
		System.out.println(result1);

	}
}
