package simplejavacalculator;

public class Buffer {
	public Double num1 = null, num2 = null;
	public Double buffered_res = null;
	
	public enum PreviouslyPressed {
		PRESSED_NONE,
		PRESSED_NUMBER,
		PRESSED_UNARY,
		PRESSED_BINARY,
		PRESSED_EQUAL,
		PRESSED_CLEAR
	};
	
	public static PreviouslyPressed pp = PreviouslyPressed.PRESSED_NONE;
	public Object c = null;
	
}
