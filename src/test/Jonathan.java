package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static java.lang.Double.NaN;

import simplejavacalculator.Calculator;
import simplejavacalculator.Calculator.BiOperatorModes;

class Jonathan {
	
	private final Calculator calculator = new Calculator();

	@Test
	void calculateBiTest_normal() {
		assertEquals(NaN, calculator.calculateBi(BiOperatorModes.normal, 1.0));
	}
	
	@Test
	// 2.0 + 1.0 = 2.0
	void calculateBiTest_add() {
		calculator.num1 = 2.0;
		calculator.mode = BiOperatorModes.add;
		assertEquals(3.0, calculator.calculateBi(calculator.mode, 1.0));
	}
	
	@Test
	// 2.0 - 1.0 = 1.0
	void calculateBiTest_minus() {
		calculator.num1 = 2.0;
		calculator.mode = BiOperatorModes.minus;
		assertEquals(1.0, calculator.calculateBi(calculator.mode, 1.0));
	}
	
	@Test
	// 2.0 * 1.0 = 2
	void calculateBiTest_multiply() {
		calculator.num1 = 2.0;
		calculator.mode = BiOperatorModes.multiply;
		assertEquals(2.0, calculator.calculateBi(calculator.mode, 1.0));
	}
	
	@Test
	// 2.0 / 1.0 = 2
	void calculateBiTest_divide() {
		calculator.num1 = 2.0;
		calculator.mode = BiOperatorModes.divide;
		assertEquals(2.0, calculator.calculateBi(calculator.mode, 1.0));
	}
	
	@Test
	// 2.0 ^ 1.0 = 2.0
	void calculateBiTest_xpowerofy() {
		calculator.num1 = 2.0;
		calculator.mode = BiOperatorModes.xpowerofy;
		assertEquals(2.0, calculator.calculateBi(calculator.mode, 1.0));
	}

}
