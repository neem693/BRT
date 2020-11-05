package interfaceFunction;

public class Main {
	
	public static void main(String[] args) {
		short[] array = {(short) 1, (short) 2, (short) 3};
		byte[] transformedArray = transformArray(array, s -> (byte) (s * 2));
		
		for(int i =0; i<transformedArray.length; i++) {
			System.out.println(transformedArray[i]);
		}
		
		
	}
	
	public static byte[] transformArray(short[] array, ShortToByteFunction function) {
	    byte[] transformedArray = new byte[array.length];
	    for (int i = 0; i < array.length; i++) {
	        transformedArray[i] = function.applyAsByte(array[i]);
	    }
	    return transformedArray;
	}
}
