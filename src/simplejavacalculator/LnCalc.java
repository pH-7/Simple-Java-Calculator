package simplejavacalculator;
import static java.lang.Math.log;

public class LnCalc implements Calculator {
	
	public double calculate(Buffer buffer) {
	
		return log(buffer.num1);
	}
}
