package simplejavacalculator.behavioral.command.commands;

import simplejavacalculator.behavioral.command.CalculatorCommand;
import simplejavacalculator.Calculator;

public class SubtractCommand implements CalculatorCommand {
    private final Calculator calculator;
    private final Double operand;
    private Double previousResult;

    public SubtractCommand(Calculator calculator, Double operand) {
        this.calculator = calculator;
        this.operand = operand;
    }

    @Override
    public Double execute() {
        previousResult = calculator.getCurrentValue();
        return calculator.calculateBi(Calculator.BiOperatorModes.minus, operand);
    }

    @Override
    public void undo() {
        calculator.setValue(previousResult);
    }
}