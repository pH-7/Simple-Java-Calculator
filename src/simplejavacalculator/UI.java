/**
 * @name        Simple Java Calculator
 * @package     ph.calculator
 * @file        UI.java
 * @author      SORIA Pierre-Henry
 * @email       pierrehs@hotmail.com
 * @link        http://github.com/pH-7
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 * @create      2012-03-30
 * 
 * @modifiedby  Achintha Gunasekara
 * @modweb      http://www.achinthagunasekara.com
 * @modemail    contact@achinthagunasekara.com
 */

package simplejavacalculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UI implements ActionListener {
	private final JFrame frame;
	private final JPanel panel;
	private final JTextArea text;
	private final JButton but[], butAdd, butMinus, butMultiply, butDivide,
			butEqual, butCancel, butSquareRoot, butSquare, butOneDevidedBy,
			butCos, butSin, butTan;
	private final Calculator calc;

	private final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9" };

	public UI() {
		frame = new JFrame("Calculator PH");
		frame.setResizable(false);
		panel = new JPanel(new FlowLayout());

		text = new JTextArea(2, 25);
		but = new JButton[10];
		for (int i = 0; i < 10; i++) {
			but[i] = new JButton(String.valueOf(i));
		}

		butAdd = new JButton("+");
		butMinus = new JButton("-");
		butMultiply = new JButton("*");
		butDivide = new JButton("/");
		butEqual = new JButton("=");
		butSquareRoot = new JButton("√");
		butSquare = new JButton("x*x");
		butOneDevidedBy = new JButton("1/x");
		butCos = new JButton("Cos");
		butSin = new JButton("Sin");
		butTan = new JButton("Tan");

		butCancel = new JButton("C");

		calc = new Calculator();
	}

	public void init() {
		frame.setVisible(true);
		frame.setSize(350, 280);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		panel.add(text);
		for (int i = 0; i < 10; i++) {
			panel.add(but[i]);
			but[i].addActionListener(this);
		}

		panel.add(butAdd);
		panel.add(butMinus);
		panel.add(butMultiply);
		panel.add(butDivide);
		panel.add(butSquare);
		panel.add(butSquareRoot);
		panel.add(butOneDevidedBy);
		panel.add(butCos);
		panel.add(butSin);
		panel.add(butTan);

		panel.add(butEqual);
		panel.add(butCancel);

		butAdd.addActionListener(this);
		butMinus.addActionListener(this);
		butMultiply.addActionListener(this);
		butDivide.addActionListener(this);
		butSquare.addActionListener(this);
		butSquareRoot.addActionListener(this);
		butOneDevidedBy.addActionListener(this);
		butCos.addActionListener(this);
		butSin.addActionListener(this);
		butTan.addActionListener(this);

		butEqual.addActionListener(this);
		butCancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final Object source = e.getSource();

		for (int i = 0; i < 10; i++) {
			if (source == but[i]) {
				text.append(buttonValue[i]);
			}
		}

		if (source == butAdd) {
			calc.setValue(Calculator.BiOperatorModes.add, reader());
			text.setText("");
		}

		if (source == butMinus) {
			calc.setValue(Calculator.BiOperatorModes.minus, reader());
			text.setText("");
		}

		if (source == butMultiply) {
			calc.setValue(Calculator.BiOperatorModes.multiply, reader());
			text.setText("");
		}

		if (source == butDivide) {
			calc.setValue(Calculator.BiOperatorModes.divide, reader());
			text.setText("");
		}

		if (source == butSquare) {
			text.setText(Double.toString(calc.calculateMono(
					Calculator.MonoOperatorModes.square, reader())));
		}

		if (source == butSquareRoot) {
			text.setText(Double.toString(calc.calculateMono(
					Calculator.MonoOperatorModes.squareRoot, reader())));
		}

		if (source == butOneDevidedBy) {
			text.setText(Double.toString(calc.calculateMono(
					Calculator.MonoOperatorModes.oneDevidedBy, reader())));
		}

		if (source == butCos) {
			text.setText(Double.toString(calc.calculateMono(
					Calculator.MonoOperatorModes.cos, reader())));
		}

		if (source == butSin) {
			text.setText(Double.toString(calc.calculateMono(
					Calculator.MonoOperatorModes.sin, reader())));
		}

		if (source == butTan) {
			text.setText(Double.toString(calc.calculateMono(
					Calculator.MonoOperatorModes.tan, reader())));
		}

		if (source == butEqual) {
			text.setText(Double.toString(calc.calculateBi(reader())));
		}

		if (source == butCancel) {
			calc.setValue(Calculator.BiOperatorModes.normal, 0.0); // reset
			text.setText("");
		}
	}

	public double reader() {
		Double num;
		String str;
		str = text.getText();
		num = Double.valueOf(str);

		return num;
	}
}
