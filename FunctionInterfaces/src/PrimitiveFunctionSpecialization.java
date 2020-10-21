import interfaceFunction.ShortToByteFunction;

public class PrimitiveFunctionSpecialization {
	
	public static void main(String[] args) {
		
//		Since a primitive type can’t be a generic type argument, there are versions of the Function interface for most used primitive types double, int, long, and their combinations in argument and return types:
//
//		    IntFunction, LongFunction, DoubleFunction: arguments are of specified type, return type is parameterized
//		    ToIntFunction, ToLongFunction, ToDoubleFunction: return type is of specified type, arguments are parameterized
//		    DoubleToIntFunction, DoubleToLongFunction, IntToDoubleFunction, IntToLongFunction, LongToIntFunction, LongToDoubleFunction — having both argument and return type defined as primitive types, as specified by their names
//
//		There is no out-of-the-box functional interface for, say, a function that takes a short and returns a byte, but nothing stops you from writing your own:
		
		short[] array = {(short) 1, (short) 2, (short) 3};
		byte[]	transformedArray = transformArray(array, s -> (byte) (s*2));
		
		byte[] expectedArray = {(byte) 2, (byte) 4, (byte) 6};
		
		for(byte b : transformedArray) {
			
			System.out.println(b);
			
		}
		for(byte b : expectedArray) {
			
			System.out.println(b);
			
		}

		
	}
	
	public static byte[] transformArray(short[] array, ShortToByteFunction function) {
		byte [] transformedArray = new byte[array.length];
		for( int i = 0; i< array.length; i++) {
			transformedArray[i] = function.applyAsByte(array[i]);
		}
		
		return transformedArray;
	}

}
