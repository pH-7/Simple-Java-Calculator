package simplejavacalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI implements ActionListener {

    private JFrame frame;
    private JTextField display;

    private Calculator calculator;

    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public UI() {
        calculator = new Calculator();
    }

    public void init() {

        frame = new JFrame("Simple Java Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        // Display
        display = new JTextField("0");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 30));
        display.setPreferredSize(new Dimension(450, 70));

        mainPanel.add(display, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(6, 4, 8, 8));

        String[] buttons = {
                "C", "x²", "√", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "0", ".", "=", "x^y",
                "sin", "cos", "tan", "log"
        };

        for (String buttonText : buttons) {

            JButton button = new JButton(buttonText);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.setFocusPainted(false);

            button.addActionListener(this);

            buttonPanel.add(button);
        }

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Extra scientific buttons
        JPanel scientificPanel = new JPanel(
                new GridLayout(1, 4, 8, 8)
        );

        String[] scientificButtons = {
                "ln", "1/x", "%", "abs"
        };

        for (String buttonText : scientificButtons) {

            JButton button = new JButton(buttonText);
            button.setFont(new Font("Arial", Font.BOLD, 16));
            button.addActionListener(this);

            scientificPanel.add(button);
        }

        mainPanel.add(scientificPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        // Number buttons
        if (command.matches("[0-9]")) {

            if (startNewNumber ||
                    display.getText().equals("0") ||
                    display.getText().equals("Error")) {

                display.setText(command);
                startNewNumber = false;

            } else {

                display.setText(
                        display.getText() + command
                );
            }

            return;
        }

        // Decimal point
        if (command.equals(".")) {

            if (startNewNumber) {

                display.setText("0.");
                startNewNumber = false;

            } else if (!display.getText().contains(".")) {

                display.setText(
                        display.getText() + "."
                );
            }

            return;
        }

        // Clear
        if (command.equals("C")) {

            display.setText("0");
            firstNumber = 0;
            operator = "";
            startNewNumber = true;

            calculator.reset();

            return;
        }

        try {

            double currentNumber =
                    Double.parseDouble(display.getText());

            // Binary operators
            if (command.equals("+") ||
                    command.equals("-") ||
                    command.equals("*") ||
                    command.equals("/") ||
                    command.equals("x^y")) {

                firstNumber = currentNumber;
                operator = command;
                startNewNumber = true;

                return;
            }

            // Equal
            if (command.equals("=")) {

                double secondNumber =
                        Double.parseDouble(display.getText());

                double result = calculate(
                        firstNumber,
                        secondNumber,
                        operator
                );

                displayResult(result);

                operator = "";
                startNewNumber = true;

                return;
            }

            // Square
            if (command.equals("x²")) {

                displayResult(
                        calculator.calculateMono(
                                Calculator.MonoOperatorModes.square,
                                currentNumber
                        )
                );

                startNewNumber = true;
                return;
            }

            // Square root
            if (command.equals("√")) {

                if (currentNumber < 0) {
                    showError();
                    return;
                }

                displayResult(
                        calculator.calculateMono(
                                Calculator.MonoOperatorModes.squareRoot,
                                currentNumber
                        )
                );

                startNewNumber = true;
                return;
            }

            // Reciprocal
            if (command.equals("1/x")) {

                if (currentNumber == 0) {
                    showError();
                    return;
                }

                displayResult(
                        calculator.calculateMono(
                                Calculator.MonoOperatorModes.oneDividedBy,
                                currentNumber
                        )
                );

                startNewNumber = true;
                return;
            }

            // Sine
            if (command.equals("sin")) {

                displayResult(
                        calculator.calculateMono(
                                Calculator.MonoOperatorModes.sin,
                                currentNumber
                        )
                );

                startNewNumber = true;
                return;
            }

            // Cosine
            if (command.equals("cos")) {

                displayResult(
                        calculator.calculateMono(
                                Calculator.MonoOperatorModes.cos,
                                currentNumber
                        )
                );

                startNewNumber = true;
                return;
            }

            // Tangent
            if (command.equals("tan")) {

                displayResult(
                        calculator.calculateMono(
                                Calculator.MonoOperatorModes.tan,
                                currentNumber
                        )
                );

                startNewNumber = true;
                return;
            }

            // Log base 10
            if (command.equals("log")) {

                if (currentNumber <= 0) {
                    showError();
                    return;
                }

                displayResult(
                        calculator.calculateMono(
                                Calculator.MonoOperatorModes.log,
                                currentNumber
                        )
                );

                startNewNumber = true;
                return;
            }

            // Natural logarithm
            if (command.equals("ln")) {

                if (currentNumber <= 0) {
                    showError();
                    return;
                }

                displayResult(
                        calculator.calculateMono(
                                Calculator.MonoOperatorModes.ln,
                                currentNumber
                        )
                );

                startNewNumber = true;
                return;
            }

            // Percentage
            if (command.equals("%")) {

                displayResult(
                        calculator.calculateMono(
                                Calculator.MonoOperatorModes.rate,
                                currentNumber
                        )
                );

                startNewNumber = true;
                return;
            }

            // Absolute value
            if (command.equals("abs")) {

                displayResult(
                        calculator.calculateMono(
                                Calculator.MonoOperatorModes.abs,
                                currentNumber
                        )
                );

                startNewNumber = true;
            }

        } catch (Exception ex) {

            showError();
        }
    }

    // Handles basic arithmetic operations
    private double calculate(
            double number1,
            double number2,
            String operation
    ) {

        switch (operation) {

            case "+":
                return number1 + number2;

            case "-":
                return number1 - number2;

            case "*":
                return number1 * number2;

            case "/":

                if (number2 == 0) {
                    throw new ArithmeticException(
                            "Cannot divide by zero"
                    );
                }

                return number1 / number2;

            case "x^y":
                return Math.pow(number1, number2);

            default:
                return number2;
        }
    }

    // Display the result
    private void displayResult(double result) {

        if (Double.isNaN(result) ||
                Double.isInfinite(result)) {

            showError();

        } else if (result == (long) result) {

            display.setText(
                    String.valueOf((long) result)
            );

        } else {

            display.setText(
                    String.valueOf(result)
            );
        }
    }

    // Display error
    private void showError() {

        display.setText("Error");
        startNewNumber = true;
    }
}