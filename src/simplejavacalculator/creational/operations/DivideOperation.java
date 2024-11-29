package simplejavacalculator.creational.operations;

import simplejavacalculator.creational.Operation;

public class DivideOperation implements Operation {
    @Override
    public Double execute(Double... numbers) {
        return numbers[0] / numbers[1];
    }

    @Override
    public String getDescription() {
        return "Division";
    }
}