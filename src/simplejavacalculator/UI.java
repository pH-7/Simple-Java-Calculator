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
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	private JTextArea text;
	private JButton but[], butAdd, butMinus, butMultiply, butDivide, butEqual, butCancel, butSquareRoot, butSquare, butOneDevidedBy, butCos, butSin, butTan;
	private Double num1, num2, result;
	private int add = 0, minus = 0, multiply = 0, divide = 0;
	String[] buttonValue = {"0","1","2","3","4","5","6","7","8","9"};

	public UI() {
		frame = new JFrame("Calculator PH");
		frame.setResizable(false);
		panel = new JPanel(new FlowLayout());
		
		text = new JTextArea(2,25);
		but = new JButton[10];
		for(int i = 0; i < 10; i++) {
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
	}
	
	public void init() {
		frame.setVisible(true);
		frame.setSize(350,280);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.add(text);
		for(int i = 0; i < 10; i++) {
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
		Object source = e.getSource();

		for(int i = 0; i < 10; i++) {
			if(source == but[i]) {
				text.append(buttonValue[i]);								
			}
		}
		
		if(source == butAdd) {
			num1 = reader();
			text.setText("");
			add = 1;
			minus = 0;
			multiply = 0;
			divide = 0;
		}
		
		if(source == butAdd) {
			num1 = reader();
			text.setText("");
			add = 1;
			minus = 0;
			multiply = 0;
			divide = 0;
		}
		
		if(source == butMinus) {
			num1 = reader();
			text.setText("");
			add = 0;
			minus = 1;
			multiply = 0;
			divide = 0;
		}
		
		if(source == butMultiply) {
			num1 = reader();
			text.setText("");
			add = 0;
			minus = 0;
			multiply = 1;
			divide = 0;
		}
		
		if(source == butDivide) {
			num1 = reader();
			text.setText("");
			add = 1;
			minus = 0;
			multiply = 0;
			divide = 1;
		}

		if(source == butSquare) {
			num1 = reader();
			result = num1*num1;
			text.setText(Double.toString(result));
		}

		if(source == butSquareRoot) {
			num1 = reader();
			result = Math.sqrt(num1);
			text.setText(Double.toString(result));
		}

		if(source == butOneDevidedBy) {
			num1 = reader();
			result = 1/num1;
			text.setText(Double.toString(result));
		}

		if(source == butCos) {
			num1 = reader();
			result = Math.cos(num1);
			text.setText(Double.toString(result));
		}

		if(source == butSin) {
			num1 = reader();
			result = Math.sin(num1);
			text.setText(Double.toString(result));
		}

		if(source == butTan) {
			num1 = reader();
			result = Math.tan(num1);
			text.setText(Double.toString(result));
		}
		
		if(source == butEqual) {
			num2 = reader();
			
			if(add > 0) {
				result = num1+num2;
				text.setText(Double.toString(result));
			}
			
			if(minus > 0) {
				result = num1-num2;
				text.setText(Double.toString(result));
			}
			
			if(multiply > 0) {
				result = num1*num2;
				text.setText(Double.toString(result));
			}
			
			if(divide > 0) {
				result = num1/num2;
				text.setText(Double.toString(result));
			}
		}
		
		if(source == butCancel) {
			num1 = 0.0;
			num2 = 0.0;
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
