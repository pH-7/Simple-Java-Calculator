package simplejavacalculator.structural;

public interface CalculatorOperation {
    Double execute(Double... numbers);
    String getDescription();
}