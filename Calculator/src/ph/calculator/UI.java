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
 */

package ph.calculator;

import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JTextArea text;
    private JButton but1, but2, but3, but4, but5, but6, but7, but8, but9, but0, butAdd, butMinus, butMultiply, butDivide, butEqual, butCancel;
    private Double num1, num2, result;
    private int add = 0, minus = 0, multiply = 0, divide = 0;
    
	public UI() {
		frame = new JFrame("Calculator PH");
		panel = new JPanel(new FlowLayout());
		
		text = new JTextArea(1,20);
		but1 = new JButton("1");
	    but2 = new JButton("2");
		but3 = new JButton("3");
		but4 = new JButton("4");
		but5 = new JButton("5");
		but6 = new JButton("6");
	    but7 = new JButton("7");
		but8 = new JButton("8");
		but9 = new JButton("9");
		but0 = new JButton("0");
		
		butAdd = new JButton("+");
		butMinus = new JButton("-");
		butMultiply = new JButton("*");
		butDivide = new JButton("/");
		butEqual = new JButton("=");
		
		butCancel = new JButton("C");
		
	}
	
	public void init() {
		frame.setVisible(true);
		frame.setSize(250,250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.add(text);
		panel.add(but1);
		panel.add(but2);
		panel.add(but3);
		panel.add(but4);
		panel.add(but5);
		panel.add(but6);
		panel.add(but7);
		panel.add(but8);
		panel.add(but9);
		panel.add(but0);
		
		panel.add(butAdd);
		panel.add(butMinus);
		panel.add(butMultiply);
		panel.add(butDivide);
		panel.add(butEqual);
		
		panel.add(butCancel);
		
		but1.addActionListener(this);
		but2.addActionListener(this);
		but3.addActionListener(this);
		but4.addActionListener(this);
		but5.addActionListener(this);
		but6.addActionListener(this);
		but7.addActionListener(this);
		but8.addActionListener(this);
		but9.addActionListener(this);
		but0.addActionListener(this);
		
		butAdd.addActionListener(this);
		butMinus.addActionListener(this);
		butMultiply.addActionListener(this);
		butDivide.addActionListener(this);
		butEqual.addActionListener(this);
		
		butCancel.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == but1) {
			text.append("1");
		}
		
		if(source == but2) {
			text.append("2");
		}

		if(source == but3) {
			text.append("3");
		}
		
		if(source == but4) {
			text.append("4");
		}
		
		if(source == but5) {
			text.append("5");
		}
		
		if(source == but6) {
			text.append("6");
		}
		
		if(source == but7) {
			text.append("7");
		}
		
		if(source == but8) {
			text.append("8");
		}
		
		if(source == but9) {
			text.append("9");
		}
		
		if(source == but0) {
			text.append("0");
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
