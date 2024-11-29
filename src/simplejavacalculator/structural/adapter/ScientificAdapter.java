package simplejavacalculator.structural.adapter;

import simplejavacalculator.structural.CalculatorOperation;

public class ScientificAdapter implements CalculatorOperation {
    private final ScientificOperation scientificOperation;
    private final String operationType;
    
    public ScientificAdapter(ScientificOperation scientificOperation, String operationType) {
        this.scientificOperation = scientificOperation;
        this.operationType = operationType;
    }
    
    @Override
    public Double execute(Double... numbers) {
        return scientificOperation.computeScientific(numbers[0]);
    }
    
    @Override
    public String getDescription() {
        return "Scientific Operation (" + operationType + ")";
    }
}