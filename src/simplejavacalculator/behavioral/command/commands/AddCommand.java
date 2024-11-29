package simplejavacalculator.behavioral.command.commands;

import simplejavacalculator.behavioral.command.CalculatorCommand;
import simplejavacalculator.Calculator;

public class AddCommand implements CalculatorCommand {
    private final Calculator calculator;
    private final Double operand;
    private Double previousResult;

    public AddCommand(Calculator calculator, Double operand) {
        this.calculator = calculator;
        this.operand = operand;
    }

    @Override
    public Double execute() {
        previousResult = calculator.getCurrentValue();
        return calculator.calculateBi(Calculator.BiOperatorModes.add, operand);
    }

    @Override
    public void undo() {
        calculator.setValue(previousResult);
    }
}