package simplejavacalculator;

public class CosCalc implements Calculator {
	public double calculate(Buffer buffer) {
		
		return Math.cos(Math.toRadians(buffer.num1));
	}
}
