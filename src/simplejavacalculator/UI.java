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
 * @modifiedby  Kydon Chantzaridis
 * @modweb      http://www.achinthagunasekara.com
 * @modemail    contact@achinthagunasekara.com
 * @modemail    kchantza@csd.auth.gr
 */

package simplejavacalculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UI implements ActionListener {
    private final JFrame frame;
    private final JPanel panel;
    private final JTextArea text;
    private final JButton but[], butAdd, butMinus, butMultiply, butDivide,
            butEqual, butCancel, butSquareRoot, butSquare, butOneDevidedBy,
            butCos, butSin, butTan, butxpowerofy, butlog, butrate, butabs;
    private final Calculator calc;

    private final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9"};

    public UI() {
        // frame = new JFrame("Calculator PH");             // original code
        frame = new JFrame("Open Source Calculator");       // new code - update the window title
        
        // frame.setResizable(false);                       // original code
         frame.setResizable(true);                          // new code - set window to be resizable
        
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
        butxpowerofy = new JButton("x^y");
        butlog = new JButton("log10(x)");
        butrate = new JButton("x%");
        butabs = new JButton("abs(x)");

        butCancel = new JButton("C");

        calc = new Calculator();
    }

    public void init() {
        frame.setVisible(true);
        frame.setSize(330, 300);        
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // original code
        
        /*
        * New Code
        * 
        * Set default close operation to do nothing, implement a WindowListener / WindowAdapter 
        * and necessary imports in order to prompt the user before leaving the calculator window.
        */
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        frame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent w) {
            int confirmation;
            confirmation = JOptionPane.showConfirmDialog(null, "Exit calculator application?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                exit(frame);
            }
        }

        private void exit(JFrame frame) {
            frame.dispose();
        }
    });

        frame.add(panel);
        panel.add(text);
       
        for (int i = 1; i < 10; i++) {
            panel.add(but[i]);
            but[i].addActionListener(this);
        }
        panel.add(but[0]);
        but[0].addActionListener(this);

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
        panel.add(butxpowerofy);
        panel.add(butlog);
        panel.add(butrate);
        panel.add(butabs);

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
        butxpowerofy.addActionListener(this);
        butlog.addActionListener(this);
        butrate.addActionListener(this);
        butabs.addActionListener(this);

        butEqual.addActionListener(this);
        butCancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();

        for (int i = 0; i < 10; i++) {
            if (source == but[i]) {
                text.replaceSelection(buttonValue[i]);
                return;
            }
        }

        if (source == butAdd) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.add, reader()));
        }

        if (source == butMinus) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.minus, reader()));
        }

        if (source == butMultiply) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.multiply,
                reader()));
        }

        if (source == butDivide) {
            writer(calc
                .calculateBi(Calculator.BiOperatorModes.divide, reader()));
        }
        if (source == butxpowerofy) {
            writer(calc
                .calculateBi(Calculator.BiOperatorModes.xpowerofy, reader()));
        }

        if (source == butSquare) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.square,
                reader()));
        }

        if (source == butSquareRoot) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.squareRoot,
                reader()));
        }

        if (source == butOneDevidedBy) {
            writer(calc.calculateMono(
                    Calculator.MonoOperatorModes.oneDevidedBy, reader()));
        }

        if (source == butCos) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.cos,
                reader()));
        }

        if (source == butSin) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.sin,
                reader()));
        }

        if (source == butTan) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.tan,
                reader()));
        }
        if (source == butlog) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.log,
                reader()));
        }
         if (source == butrate) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.rate,
                reader()));
        }
         if(source == butabs){
             writer(calc.calculateMono(Calculator.MonoOperatorModes.abs, reader()));
         }

        if (source == butEqual) {
            writer(calc.calculateEqual(reader()));
        }

        if (source == butCancel) {
            writer(calc.reset());
        }
        
        text.selectAll();
    }

    public Double reader() {
        Double num;
        String str;
        str = text.getText();
        num = Double.valueOf(str);

        return num;
    }

    public void writer(final Double num) {
        if (Double.isNaN(num)) {
            text.setText("");
        } else {
            text.setText(Double.toString(num));
        }
    }
}
