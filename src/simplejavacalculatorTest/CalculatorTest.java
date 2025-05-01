package simplejavacalculatorTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static java.lang.Double.NaN;
import java.lang.Math;

import simplejavacalculator.Calculator;

class CalculatorTest {

	// Teste da operação "Elevado a"
	@Test
	void calculateBiXPowerYTest() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.xpowerofy, 2.0);
		Assertions.assertEquals(8.0, calculator.calculateBi(Calculator.BiOperatorModes.normal, 3.0)); // 2^3
	}

	// Teste da operação Ln
	@Test
	void calculateMonoLnTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(0, calculator.calculateMono(Calculator.MonoOperatorModes.ln, 1.0)); // ln1
	}

	// Teste da operação Tangente resultando em NaN
	@Test
	void calculateMonoTanUndefinedTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(NaN, calculator.calculateMono(Calculator.MonoOperatorModes.tan, 90.0)); // tan(90)
	}
	
	// Teste da operação Tangente de zero resultando em zero
	@Test
	void calculateMonoTanZeroZeroTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(0.0, calculator.calculateMono(Calculator.MonoOperatorModes.tan, 0.0)); // tan(0)
	}

	// Teste da operação Tangente de 180 resultando em zero
	@Test
	void calculateMonoTan180ZeroTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(0.0, calculator.calculateMono(Calculator.MonoOperatorModes.tan, 180.0)); // tan(180)
	}

	// Teste da operação Log com o valor 0
	@Test
	void calculateMonoLogZeroTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(Double.NEGATIVE_INFINITY, calculator.calculateMono(Calculator.MonoOperatorModes.log, 0.0)); // log0
	}

	// Teste da operação Log com valor negativo
	@Test
	void calculateMonoLogNegativeTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(NaN, calculator.calculateMono(Calculator.MonoOperatorModes.log, -2.0)); // log-2
	}

	// Teste da operação ln com valor negativo
	@Test
	void calculateMonoLnNegativeTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(NaN, calculator.calculateMono(Calculator.MonoOperatorModes.ln, -3.0)); // ln-3
	}

	// Teste da operação ln com o valor 0
	@Test
	void calculateMonoLnZeroTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(Double.NEGATIVE_INFINITY, calculator.calculateMono(Calculator.MonoOperatorModes.ln, 0.0)); // ln0
	}

	// Teste da operação "um dividido por" por 0
	@Test
	void calculateMonoDivideByZeroTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(NaN, calculator.calculateMono(Calculator.MonoOperatorModes.oneDividedBy, 0.0)); // 1/0
	}

	// Teste da operação de divisão por 0
	@Test
	void calculateBiDivideTest() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.divide, 10.0);
		Assertions.assertEquals(NaN, calculator.calculateBi(Calculator.BiOperatorModes.normal, 0.0)); // 10/0
	}

	// Teste de multiplas operações
	@Test
	void testMultipleOperationsChain() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.add, 2.0); // 2
		calculator.calculateBi(Calculator.BiOperatorModes.multiply, 3.0); // * 3 = 6
		Assertions.assertEquals(18.0, calculator.calculateEqual(3.0)); // * 3 = 18 (Vezes novamente por ser o ultimo
																		// operador)
	}

	// Teste da operação raiz quadrada com valor negativo
@Test
void calculateMonoSqrtNegativeTest() {
	Calculator calculator = new Calculator();
	Assertions.assertEquals(NaN, calculator.calculateMono(Calculator.MonoOperatorModes.squareRoot, -9.0)); //sqrt(-9)
}

	// Teste de unica entrada e operação "Igual"

	@Test
	void testEqualAfterAddition() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.add, 5.0);
		Assertions.assertEquals(10.0, calculator.calculateEqual(5.0)); // 5 + 5
	}

	@Test
	void testEqualAfterSubtraction() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.minus, 8.0);
		Assertions.assertEquals(3.0, calculator.calculateEqual(5.0)); // 8 - 5
	}

	@Test
	void testEqualAfterMultiplication() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.multiply, 4.0);
		Assertions.assertEquals(20.0, calculator.calculateEqual(5.0)); // 4 * 5
	}

	@Test
	void testEqualAfterDivision() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.divide, 10.0);
		Assertions.assertEquals(2.0, calculator.calculateEqual(5.0)); // 10 / 5
	}

	@Test
	void testEqualAfterPower() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.xpowerofy, 2.0);
		Assertions.assertEquals(32.0, calculator.calculateEqual(5.0)); // 2^5
	}

	@Test
    void testNormalOperation() {
        Calculator calculator = new Calculator();
        calculator.calculateBi(Calculator.BiOperatorModes.normal, 5.0);
        Assertions.assertEquals(NaN, calculator.calculateEqual(5.0));
	}

	@Test
    void calculateBiAddTest() {
        Calculator calculator = new Calculator();
        calculator.calculateBi(Calculator.BiOperatorModes.add, 2.5);
        Assertions.assertEquals(2.5, calculator.calculateBi(Calculator.BiOperatorModes.normal, 0.0));
    }

}
