package simplejavacalculator;

public class SquareCalc implements Calculator {
	
	public double calculate(Buffer buffer) {
		
		return buffer.num1 * buffer.num1;
	}

}
