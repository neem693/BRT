import interfaceFunction.ShortToByteFunction;

public class PrimitiveFunctionSpecialization {
	
	public static void main(String[] args) {
		
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
