package simplejavacalculator;

import static java.lang.Double.NaN;
import static java.lang.Math.*;
import java.util.HashMap;
import java.util.Map;
import simplejavacalculator.behavioral.command.*;
import simplejavacalculator.behavioral.strategy.*;
import simplejavacalculator.creational.*;
import simplejavacalculator.structural.*;
import simplejavacalculator.structural.adapter.*;
import simplejavacalculator.structural.decorator.*;

public class Calculator {
    public enum BiOperatorModes {
        normal, add, minus, multiply, divide, xpowerofy 
    }

    public enum MonoOperatorModes {
        square, squareRoot, oneDividedBy, cos, sin, tan, log, rate, abs, ln
    }

    private Double currentValue = 0.0;
    private Double num1, num2;
    private BiOperatorModes mode = BiOperatorModes.normal;
    private final Map<String, CalculatorOperation> operations;
    private final OperationFactory factory;
    private final CalculatorBuilder builder;
    private final CommandHistory history;
    private CalculationStrategy strategy;

    public Calculator() {
        this.operations = new HashMap<>();
        this.factory = new OperationFactory();
        this.builder = new CalculatorBuilder();
        this.history = new CommandHistory();
        this.strategy = new BasicStrategy();
        initializeOperations();
    }

    private void initializeOperations() {
        // Basic operations with factory and logging decorator
        Operation addOp = factory.createOperation("add");
        Operation subOp = factory.createOperation("subtract");
        Operation mulOp = factory.createOperation("multiply");
        Operation divOp = factory.createOperation("divide");

        operations.put("add", new LoggingDecorator(new CalculatorOperationAdapter(addOp)));
        operations.put("subtract", new LoggingDecorator(new CalculatorOperationAdapter(subOp)));
        operations.put("multiply", new LoggingDecorator(new CalculatorOperationAdapter(mulOp)));
        operations.put("divide", new LoggingDecorator(new CalculatorOperationAdapter(divOp)));
        
        // Scientific operations with adapter
        operations.put("sin", new LoggingDecorator(
            new ScientificAdapter(new TrigonometricOperation("sin"), "sin")
        ));
        operations.put("cos", new LoggingDecorator(
            new ScientificAdapter(new TrigonometricOperation("cos"), "cos")
        ));
        operations.put("tan", new LoggingDecorator(
            new ScientificAdapter(new TrigonometricOperation("tan"), "tan")
        ));
    }

    private class CalculatorOperationAdapter implements CalculatorOperation {
        private final Operation operation;

        public CalculatorOperationAdapter(Operation operation) {
            this.operation = operation;
        }

        @Override
        public Double execute(Double... numbers) {
            return operation.execute(numbers);
        }

        @Override
        public String getDescription() {
            return operation.getDescription();
        }
    }

    public void setStrategy(CalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setValue(Double value) {
        this.currentValue = value;
    }

    public void executeCommand(CalculatorCommand command) {
        history.executeCommand(command);
    }

    public void undo() {
        history.undo();
    }

    public void redo() {
        history.redo();
    }

    private Double calculateBiImpl() {
        if (mode.equals(BiOperatorModes.normal)) {
            return num2;
        }

        String operationType = null;
        switch (mode) {
            case add: operationType = "add"; break;
            case minus: operationType = "subtract"; break;
            case multiply: operationType = "multiply"; break;
            case divide: operationType = "divide"; break;
            case xpowerofy: return strategy.calculate(num1, num2);
        }

        if (operationType != null) {
            CalculatorOperation operation = operations.get(operationType);
            if (operation != null) {
                return operation.execute(num1, num2);
            }
        }

        throw new Error("Invalid operation");
    }

    public Double calculateBi(BiOperatorModes newMode, Double num) {
        if (mode.equals(BiOperatorModes.normal)) {
            num2 = 0.0;
            num1 = num;
            mode = newMode;
            currentValue = num1;
            return NaN;
        } else {
            num2 = num;
            num1 = calculateBiImpl();
            mode = newMode;
            currentValue = num1;
            return num1;
        }
    }

    public Double calculateEqual(Double num) {
        return calculateBi(BiOperatorModes.normal, num);
    }

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        currentValue = 0.0;
        mode = BiOperatorModes.normal;
        return NaN;
    }
    
    public Double calculateMono(MonoOperatorModes newMode, Double num) {
        Double result = switch (newMode) {
            case square -> num * num;
            case squareRoot -> Math.sqrt(num);
            case oneDividedBy -> 1 / num;
            case cos -> Math.cos(Math.toRadians(num));
            case sin -> Math.sin(Math.toRadians(num));
            case tan -> {
                if (num == 0 || num % 180 == 0) yield 0.0;
                if (num % 90 == 0.0 && num % 180 != 0.0) yield NaN;
                yield Math.tan(Math.toRadians(num));
            }
            case log -> log10(num);
            case ln -> log(num);
            case rate -> num / 100;
            case abs -> Math.abs(num);
        };
        currentValue = result;
        return result;
    }
}