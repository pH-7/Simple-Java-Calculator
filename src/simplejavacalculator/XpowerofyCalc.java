package simplejavacalculator;
import static java.lang.Math.pow;

public class XpowerofyCalc implements Calculator {
	public double calculate(Buffer buffer) {
		return pow(buffer.num1, buffer.num2);
	}
}