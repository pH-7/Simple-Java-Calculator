package simplejavacalculator.behavioral.strategy;

public class BasicStrategy implements CalculationStrategy {
    @Override
    public Double calculate(Double a, Double b) {
        return a + b;
    }
}