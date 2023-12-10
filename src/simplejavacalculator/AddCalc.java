package simplejavacalculator;

public class AddCalc implements Calculator {
	
	public double calculate(Buffer buffer) {
		
		return buffer.num1 + buffer.num2;
	}
}
