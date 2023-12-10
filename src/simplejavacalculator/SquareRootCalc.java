package simplejavacalculator;

public class SquareRootCalc implements Calculator {
	
	public double calculate(Buffer buffer) {
		
		return Math.sqrt(buffer.num1);
	}

}
