package simplejavacalculator;

import static java.lang.Double.NaN;

public class TanCalc implements Calculator {
	
	public double calculate(Buffer buffer) {
		
            if (buffer.num1 == 0 || buffer.num1 % 180 == 0) {
                return 0.0;
            }
            
            if (buffer.num1 % 90 == 0 && buffer.num1 % 180 != 0) {
                return NaN;
            }
            
            return Math.tan(Math.toRadians(buffer.num1));
    }
}
