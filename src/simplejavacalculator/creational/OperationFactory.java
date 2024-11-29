package simplejavacalculator.creational;

import simplejavacalculator.creational.operations.*;

public class OperationFactory {
    public Operation createOperation(String type) {
        if ("add".equals(type)) {
            return new AddOperation();
        } else if ("subtract".equals(type)) {
            return new SubtractOperation();
        } else if ("multiply".equals(type)) {
            return new MultiplyOperation();
        } else if ("divide".equals(type)) {
            return new DivideOperation();
        }
        throw new IllegalArgumentException("Unknown operation: " + type);
    }
}
