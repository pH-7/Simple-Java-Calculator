package simplejavacalculator.behavioral.command;

public interface CalculatorCommand {
    Double execute();
    void undo();
}
