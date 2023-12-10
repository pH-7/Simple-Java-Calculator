package simplejavacalculator;

public class SinCalc implements Calculator {
	public double calculate(Buffer buffer) {
		
		return Math.sin(Math.toRadians(buffer.num1));
	}
}
