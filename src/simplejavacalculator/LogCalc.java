package simplejavacalculator;

import static java.lang.Math.log10;

public class LogCalc implements Calculator {

	public double calculate(Buffer buffer) {
		
		 return log10(buffer.num1);
	}
}
