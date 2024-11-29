package simplejavacalculator.behavioral.command;

import java.util.Stack;

public class CommandHistory {
    private final Stack<CalculatorCommand> undoStack = new Stack<>();
    private final Stack<CalculatorCommand> redoStack = new Stack<>();

    public void executeCommand(CalculatorCommand command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            CalculatorCommand command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            CalculatorCommand command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }
}