package simplejavacalculatorTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static java.lang.Double.NaN;

import simplejavacalculator.Calculator;

class CalculatorTest {

    // Tests the "x to the power of y" binary operation
    @Test
    void calculateBiXPowerYTest() {
        Calculator calculator = new Calculator();
        calculator.calculateBi(Calculator.BiOperatorModes.xpowerofy, 2.0);
        Assertions.assertEquals(8.0, calculator.calculateBi(Calculator.BiOperatorModes.normal, 3.0)); // 2^3
    }

    // Tests natural logarithm (ln) of 1, which should be 0
    @Test
    void calculateMonoLnTest() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(0, calculator.calculateMono(Calculator.MonoOperatorModes.ln, 1.0)); // ln(1)
    }

    // Tests tangent of 90 degrees, which is undefined (NaN)
    @Test
    void calculateMonoTanUndefinedTest() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(NaN, calculator.calculateMono(Calculator.MonoOperatorModes.tan, 90.0)); // tan(90)
    }

    // Tests tangent of 0, which should be 0
    @Test
    void calculateMonoTanZeroZeroTest() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(0.0, calculator.calculateMono(Calculator.MonoOperatorModes.tan, 0.0)); // tan(0)
    }

    // Tests tangent of 180, which should be 0
    @Test
    void calculateMonoTan180ZeroTest() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(0.0, calculator.calculateMono(Calculator.MonoOperatorModes.tan, 180.0)); // tan(180)
    }

    // Tests logarithm base 10 of 0, which should be negative infinity
    @Test
    void calculateMonoLogZeroTest() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(Double.NEGATIVE_INFINITY, calculator.calculateMono(Calculator.MonoOperatorModes.log, 0.0)); // log(0)
    }

    // Tests logarithm base 10 of a negative number, which is undefined (NaN)
    @Test
    void calculateMonoLogNegativeTest() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(NaN, calculator.calculateMono(Calculator.MonoOperatorModes.log, -2.0)); // log(-2)
    }

    // Tests natural logarithm of a negative number, which is undefined (NaN)
    @Test
    void calculateMonoLnNegativeTest() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(NaN, calculator.calculateMono(Calculator.MonoOperatorModes.ln, -3.0)); // ln(-3)
    }

    // Tests natural logarithm of 0, which should be negative infinity
    @Test
    void calculateMonoLnZeroTest() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(Double.NEGATIVE_INFINITY, calculator.calculateMono(Calculator.MonoOperatorModes.ln, 0.0)); // ln(0)
    }

    // Tests reciprocal operation (1/x) with 0, which is undefined (NaN)
    @Test
    void calculateMonoDivideByZeroTest() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(NaN, calculator.calculateMono(Calculator.MonoOperatorModes.oneDividedBy, 0.0)); // 1/0
    }

    // Tests division by 0 using binary operation, which is undefined (NaN)
    @Test
    void calculateBiDivideTest() {
        Calculator calculator = new Calculator();
        calculator.calculateBi(Calculator.BiOperatorModes.divide, 10.0);
        Assertions.assertEquals(NaN, calculator.calculateBi(Calculator.BiOperatorModes.normal, 0.0)); // 10/0
    }

    // Tests a sequence of binary operations ending with multiplication
    @Test
    void testMultipleOperationsChain() {
        Calculator calculator = new Calculator();
        calculator.calculateBi(Calculator.BiOperatorModes.add, 2.0);       // 2
        calculator.calculateBi(Calculator.BiOperatorModes.multiply, 3.0);  // 2 * 3 = 6
        Assertions.assertEquals(18.0, calculator.calculateEqual(3.0));     // 6 * 3 = 18
    }

    // Tests square root of a negative number, which is undefined (NaN)
    @Test
    void calculateMonoSqrtNegativeTest() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(NaN, calculator.calculateMono(Calculator.MonoOperatorModes.squareRoot, -9.0)); // sqrt(-9)
    }

    // Tests equality after addition
    @Test
    void testEqualAfterAddition() {
        Calculator calculator = new Calculator();
        calculator.calculateBi(Calculator.BiOperatorModes.add, 5.0);
        Assertions.assertEquals(10.0, calculator.calculateEqual(5.0)); // 5 + 5
    }

    // Tests equality after subtraction
    @Test
    void testEqualAfterSubtraction() {
        Calculator calculator = new Calculator();
        calculator.calculateBi(Calculator.BiOperatorModes.minus, 8.0);
        Assertions.assertEquals(3.0, calculator.calculateEqual(5.0)); // 8 - 5
    }

    // Tests equality after multiplication
    @Test
    void testEqualAfterMultiplication() {
        Calculator calculator = new Calculator();
        calculator.calculateBi(Calculator.BiOperatorModes.multiply, 4.0);
        Assertions.assertEquals(20.0, calculator.calculateEqual(5.0)); // 4 * 5
    }

    // Tests equality after division
    @Test
    void testEqualAfterDivision() {
        Calculator calculator = new Calculator();
        calculator.calculateBi(Calculator.BiOperatorModes.divide, 10.0);
        Assertions.assertEquals(2.0, calculator.calculateEqual(5.0)); // 10 / 5
    }

    // Tests equality after exponentiation
    @Test
    void testEqualAfterPower() {
        Calculator calculator = new Calculator();
        calculator.calculateBi(Calculator.BiOperatorModes.xpowerofy, 2.0);
        Assertions.assertEquals(32.0, calculator.calculateEqual(5.0)); // 2^5
    }

    // Tests normal binary operation mode (should return NaN)
    @Test
    void testNormalOperation() {
        Calculator calculator = new Calculator();
        calculator.calculateBi(Calculator.BiOperatorModes.normal, 5.0);
        Assertions.assertEquals(NaN, calculator.calculateEqual(5.0));
    }

    // Tests addition followed by immediate evaluation (normal mode)
    @Test
    void calculateBiAddTest() {
        Calculator calculator = new Calculator();
        calculator.calculateBi(Calculator.BiOperatorModes.add, 2.5);
        Assertions.assertEquals(2.5, calculator.calculateBi(Calculator.BiOperatorModes.normal, 0.0)); // 2.5 + 0
    }
}
