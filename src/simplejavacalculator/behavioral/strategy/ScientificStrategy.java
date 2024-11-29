package simplejavacalculator.behavioral.strategy;

public class ScientificStrategy implements CalculationStrategy {
    @Override
    public Double calculate(Double a, Double b) {
        return Math.pow(a, b);
    }
}