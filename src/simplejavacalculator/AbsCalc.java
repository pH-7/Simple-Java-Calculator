package simplejavacalculator;

public class AbsCalc implements Calculator {
	public double calculate(Buffer buffer) {
		return Math.abs(buffer.num1);
	}
}
