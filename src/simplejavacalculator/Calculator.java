package simplejavacalculator;

public class Calculator {
	public enum BiOperatorModes {
		normal, add, minus, multiply, divide
	}

	public enum MonoOperatorModes {
		square, squareRoot, oneDevidedBy, cos, sin, tan
	}

	private Double num1;
	private BiOperatorModes mode;

	public void setValue(BiOperatorModes newMode, Double num) {
		mode = newMode;
		num1 = num;
	}

	public Double calculateMono(MonoOperatorModes newMode, Double num) {
		if (newMode == Calculator.MonoOperatorModes.square) {
			return num * num;
		}
		if (newMode == Calculator.MonoOperatorModes.squareRoot) {
			return Math.sqrt(num);
		}
		if (newMode == Calculator.MonoOperatorModes.oneDevidedBy) {
			return 1 / num;
		}
		if (newMode == Calculator.MonoOperatorModes.cos) {
			return Math.cos(num);
		}
		if (newMode == Calculator.MonoOperatorModes.sin) {
			return Math.sin(num);
		}
		if (newMode == Calculator.MonoOperatorModes.tan) {
			return Math.tan(num);
		}

		// never reach
		throw new Error();
	}

	public Double calculateBi(Double num) {
		if (mode == Calculator.BiOperatorModes.normal) {
			return num;
		}
		if (mode == Calculator.BiOperatorModes.add) {
			return num1 + num;
		}
		if (mode == Calculator.BiOperatorModes.minus) {
			return num1 - num;
		}
		if (mode == Calculator.BiOperatorModes.multiply) {
			return num1 * num;
		}
		if (mode == Calculator.BiOperatorModes.divide) {
			return num1 / num;
		}

		// never reach
		throw new Error();
	}
}
