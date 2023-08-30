package simplejavacalculatorTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static java.lang.Double.NaN;
import java.lang.Math;


import simplejavacalculator.Calculator;

class CalculatorTest{
	
	  @Test
	    void calculateBiModTest() {
	        Calculator calculator = new Calculator();
	        calculator.calculateBi(Calculator.BiOperatorModes.mod, 7.0);
	        Assertions.assertEquals(3.0, calculator.calculateBi(Calculator.BiOperatorModes.mod, 4.0));
	    }
	 
	@Test
	void calculateBiNormalTest() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.normal, 2.0);
		Assertions.assertEquals(NaN, calculator.calculateBi(Calculator.BiOperatorModes.normal, 3.0));
    }
	
	@Test
	void calculateBiAddTest() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.add, 3.0);
		Assertions.assertEquals(5.5, calculator.calculateBi(Calculator.BiOperatorModes.normal, 2.5));
	}
	
	@Test
	void calculateBiMinusTest() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.minus, 3.1415);
		Assertions.assertEquals(2.0415, calculator.calculateBi(Calculator.BiOperatorModes.normal, 1.1));
	}
	
	@Test
	void calculateBiMultiplyTest() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.multiply, 3.2);
		Assertions.assertEquals(6.4, calculator.calculateBi(Calculator.BiOperatorModes.normal, 2.0));
	}
	
	@Test
	void calculateBiDivideTest() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.divide, 6.4);
		Assertions.assertEquals(3.2, calculator.calculateBi(Calculator.BiOperatorModes.normal, 2.0));
	}
	
	@Test
	void calculateEqualTest() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.add, 6.4);
		calculator.calculateBi(Calculator.BiOperatorModes.add, 2.0);
		Assertions.assertEquals(11.4, calculator.calculateEqual(3.0));
	}
	
	@Test
	void resetTest() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.add, 6.4);
		Assertions.assertEquals(8.4, calculator.calculateBi(Calculator.BiOperatorModes.add, 2.0));
		Assertions.assertEquals(NaN, calculator.reset());		
	}
	
	@Test
	void CalculateMonoSquareTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(9.0, calculator.calculateMono(Calculator.MonoOperatorModes.square, 3.0));
	}
	
	@Test
	void CalculateMonoSquareRootTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(5.0, calculator.calculateMono(Calculator.MonoOperatorModes.squareRoot, 25.0));
	}
	
	@Test
	void CalculateMonoOneDividedByTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(0.10, calculator.calculateMono(Calculator.MonoOperatorModes.oneDividedBy, 10.0));
	}
	
	//Math.cos(π/3)≈ 0.5
	@Test
    void calculateMonoCosTest() {
        Calculator calculator = new Calculator();
        double result = calculator.calculateMono(Calculator.MonoOperatorModes.cos, 60.0);
        Assertions.assertEquals(Math.cos(Math.toRadians(60.0)), result);
    }

	//Math.sin(π/6) ≈ 0.5
    @Test
    void calculateMonoSinTest() {
        Calculator calculator = new Calculator();
        double result = calculator.calculateMono(Calculator.MonoOperatorModes.sin, 30.0);
        Assertions.assertEquals(Math.sin(Math.toRadians(30.0)), result);
    }

    //Math.tan(π/4) = 1.0
    @Test
    void calculateMonoTanTest() {
        Calculator calculator = new Calculator();
        double result = calculator.calculateMono(Calculator.MonoOperatorModes.tan, 45.0);
        Assertions.assertEquals(Math.tan(Math.toRadians(45.0)), result);
    }

    //0.0
    @Test
    void calculateMonoTanZeroTest() {
        Calculator calculator = new Calculator();
        double result = calculator.calculateMono(Calculator.MonoOperatorModes.tan, 0.0);
        Assertions.assertEquals(0.0, result);
    }
    
    //undefined
    @Test
    void calculateMonoTanNaNTest() {
        Calculator calculator = new Calculator();
        double result = calculator.calculateMono(Calculator.MonoOperatorModes.tan, 90.0);
        Assertions.assertTrue(Double.isNaN(result));
    }
    
	@Test
	void CalculateMonoLogTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(2.0, calculator.calculateMono(Calculator.MonoOperatorModes.log, 100.0));
	}
	
	@Test
	void CalculateMonoRateTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(.75, calculator.calculateMono(Calculator.MonoOperatorModes.rate, 75.0));
	}
	
	@Test
	void CalculateMonoAbsTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(3.0, calculator.calculateMono(Calculator.MonoOperatorModes.abs, -3.0));
		Assertions.assertEquals(3.0, calculator.calculateMono(Calculator.MonoOperatorModes.abs, 3.0));
	}
	@Test
    void calculateMonoFactorialTest() {
        Calculator calculator = new Calculator();
        double result = calculator.calculateMono(Calculator.MonoOperatorModes.factorial, 5.0);
        Assertions.assertEquals(120.0, result);
    }
	

}