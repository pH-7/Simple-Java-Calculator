package simplejavacalculator.structural.decorator;

import simplejavacalculator.structural.CalculatorOperation;

public class LoggingDecorator extends OperationDecorator {
    public LoggingDecorator(CalculatorOperation operation) {
        super(operation);
    }
    
    @Override
    public Double execute(Double... numbers) {
        System.out.println("Executing: " + getDescription());
        System.out.println("Input numbers: " + java.util.Arrays.toString(numbers));
        Double result = operation.execute(numbers);
        System.out.println("Result: " + result);
        return result;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " (with logging)";
    }
}