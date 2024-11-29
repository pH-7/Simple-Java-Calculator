package simplejavacalculator.structural.decorator;

import simplejavacalculator.structural.CalculatorOperation;

public abstract class OperationDecorator implements CalculatorOperation {
    protected CalculatorOperation operation;
    
    public OperationDecorator(CalculatorOperation operation) {
        this.operation = operation;
    }

    @Override
    public String getDescription() {
        return operation.getDescription();
    }
}