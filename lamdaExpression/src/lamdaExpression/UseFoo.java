package lamdaExpression;

import java.util.function.Function;

public class UseFoo {
	
	public String add(String str,Foo foo) {
		return foo.method(str);
	}
	
	public String add(String str, Function<String,String> fn) {
		
		return fn.apply(str);
		
	}

}
