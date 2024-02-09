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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Box;
import javax.swing.BoxLayout;

import javax.swing.ImageIcon;
import java.io.*;

public class UI implements ActionListener {
   
   private final JFrame frame;
   
   private final JPanel panel;
   private final JPanel panelSub1;
   private final JPanel panelSub2;
   private final JPanel panelSub3;
   private final JPanel panelSub4;
   private final JPanel panelSub5;
   private final JPanel panelSub6;
   private final JPanel panelSub7;
   private final JPanel panelSub8;
   
   private final JTextArea text;
   private boolean colourCounter;
   
   private final JButton but[], butAdd, butMinus, butMultiply, butDivide,
      butEqual, butCancel,butSquareRoot, butSquare, butOneDividedBy,
      butCos, butSin, butTan, butxpowerofy, butlog, butrate, butabs, butBinary, butln,butContrast;
   private final Calculator calc;
   
   private final String[] buttonValue = {"0", "1", "2", "3", "4", "5", "6",
      "7", "8", "9"};
   

   private final Font font;
   private final Font textFont;
   private ImageIcon image;
   private BufferedImageCustom imageReturn;
   
   public UI() throws IOException {
      frame = new JFrame("Calculator PH");

      imageReturn = new BufferedImageCustom();
      image = new ImageIcon(imageReturn.imageReturn());      
      
      panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      panelSub1 = new JPanel(new FlowLayout());
      panelSub2 = new JPanel(new FlowLayout());
      panelSub3 = new JPanel(new FlowLayout());
      panelSub4 = new JPanel(new FlowLayout());
      panelSub5 = new JPanel(new FlowLayout());
      panelSub6 = new JPanel(new FlowLayout());
      panelSub7 = new JPanel(new FlowLayout());
      panelSub8 = new JPanel(new FlowLayout());
      
      font = new Font("Consolas",Font.PLAIN, 18);
      
      text = new JTextArea(1, 30);
      
      textFont = new Font("Consolas",Font.BOLD, 24);
      //colourCounter = false;
      but = new JButton[11];
      for (int i = 0; i < 11; i++) {
    		 but[i] = new JButton(String.valueOf(i));
      }      
      butAdd = new JButton("+");      
      butMinus = new JButton("-");      
      butMultiply = new JButton("*");      
      butDivide = new JButton("/");      
      butEqual = new JButton("=");      
      butSquareRoot = new JButton("sqrt");      
      butSquare = new JButton("x*x");      
      butOneDividedBy = new JButton("1/x");      
      butCos = new JButton("Cos");      
      butSin = new JButton("Sin");      
      butTan = new JButton("Tan");      
      butln = new JButton("ln");     
      butxpowerofy = new JButton("x^y");      
      butlog = new JButton("log10(x)");      
      butrate = new JButton("x%");      
      butabs = new JButton("abs(x)");
      butCancel = new JButton("C");
      butBinary = new JButton("Bin");
      butContrast = new JButton("Contrast");
      calc = new Calculator();
      
   }
   
   public void init() {      
      frame.setSize(450, 450);
      frame.setLocationRelativeTo(null); 
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setIconImage(image.getImage());
      
      text.setFont(textFont);
      text.setEditable(false);
      
      for (int i = 0; i < 11; i++) {
         but[i].setFont(font);
      }      
      butAdd.setFont(font);
      butMinus.setFont(font);
      butMultiply.setFont(font);
      butDivide.setFont(font);
      butEqual.setFont(font);
      butSquareRoot.setFont(font);
      butSquare.setFont(font);
      butOneDividedBy.setFont(font);
      butCos.setFont(font);
      butSin.setFont(font);
      butTan.setFont(font);
      butln.setFont(font); 
      butxpowerofy.setFont(font);
      butlog.setFont(font);
      butrate.setFont(font);
      butabs.setFont(font);
      butCancel.setFont(font);
      butBinary.setFont(font);
      butContrast.setFont(font);
      
      panel.add(Box.createHorizontalStrut(100));
      panelSub1.add(text);
      panel.add(panelSub1);
      
      panelSub2.add(but[1]);
      panelSub2.add(but[2]);
      panelSub2.add(but[3]);
      panelSub2.add(Box.createHorizontalStrut(15));
      panelSub2.add(butAdd);
      panelSub2.add(butMinus);
      panel.add(panelSub2);
      
      panelSub3.add(but[4]);
      panelSub3.add(but[5]);
      panelSub3.add(but[6]);
      panelSub3.add(Box.createHorizontalStrut(15));
      panelSub3.add(butMultiply);
      panelSub3.add(butDivide);      
      panel.add(panelSub3);
      
      panelSub4.add(but[7]);
      panelSub4.add(but[8]);
      panelSub4.add(but[9]);
      panelSub4.add(Box.createHorizontalStrut(15));
      panelSub4.add(butEqual);
      panelSub4.add(butCancel);
      panel.add(panelSub4);
      
      panelSub5.add(Box.createHorizontalStrut(92));
      panelSub5.add(but[0]);
      panelSub5.add(butln);
      panelSub5.add(butContrast);
      panelSub5.add(Box.createHorizontalStrut(210));
      panel.add(panelSub5);
      
      panelSub6.add(butSquare);
      panelSub6.add(butSquareRoot);
      panelSub6.add(butOneDividedBy);
      panelSub6.add(butxpowerofy);
      panel.add(panelSub6);
      
      panelSub7.add(butCos);
      panelSub7.add(butSin);
      panelSub7.add(butTan);
      panel.add(panelSub7);
      
      panelSub8.add(butlog);
      panelSub8.add(butrate);
      panelSub8.add(butabs);
      panelSub8.add(butBinary);
      panel.add(panelSub8);
      panel.setOpaque(true);
      
      for (int i = 0; i < 11; i++) {
         but[i].addActionListener(this);
      }      
      butAdd.addActionListener(this);
      butMinus.addActionListener(this);
      butMultiply.addActionListener(this);
      butDivide.addActionListener(this);
      butSquare.addActionListener(this);
      butSquareRoot.addActionListener(this);
      butOneDividedBy.addActionListener(this);
      butCos.addActionListener(this);
      butSin.addActionListener(this);
      butTan.addActionListener(this);
      butln.addActionListener(this); 
      butxpowerofy.addActionListener(this);
      butlog.addActionListener(this);
      butrate.addActionListener(this);
      butabs.addActionListener(this);
      butBinary.addActionListener(this);
      
      butEqual.addActionListener(this);
      butCancel.addActionListener(this);
      butContrast.addActionListener(this);
      
      frame.add(panel);
      frame.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      final Object source = e.getSource();
      Double checkNum = null;

      for (int i = 0; i < 11; i++) {
         if (source == but[i]) {
            text.replaceSelection(buttonValue[i]);
            return;
         }
      }

    
      try {
         checkNum = Double.parseDouble(text.getText());
      } catch(NumberFormatException k) {

      }

      if (checkNum != null || source == butCancel) {
         if (source == butAdd) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.add, reader()));
            text.replaceSelection(butAdd.getText());
         }

         if (source == butMinus) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.minus, reader()));
            text.replaceSelection(butMinus.getText());
         }

         if (source == butMultiply) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.multiply, reader()));
            text.replaceSelection(butMultiply.getText());
         }

         if (source == butDivide) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.divide, reader()));
            text.replaceSelection(butDivide.getText());
         }
         
         if (source == butxpowerofy) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.xpowerofy, reader()));
         }

         if (source == butSquare) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.square, reader()));
         }

         if (source == butSquareRoot)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.squareRoot, reader()));

         if (source == butOneDividedBy)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.oneDividedBy, reader()));

         if (source == butCos)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.cos, reader()));

         if (source == butSin)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.sin, reader()));

         if (source == butTan)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.tan, reader()));

         if (source == butlog)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.log, reader()));

         if (source == butln)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.ln, reader())); 

         if (source == butrate)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.rate, reader()));

         if (source == butabs)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.abs, reader()));

         if (source == butEqual)
            writer(calc.calculateEqual(reader()));

         if (source == butCancel)
            writer(calc.reset());

         if (source == butBinary)
            parsetoBinary();

      }
      if(source == butContrast)
         contrastButton();

      text.selectAll();
   }
   
   private void parsetoBinary() {
      try {
         text.setText("" + Long.toBinaryString(Long.parseLong(text.getText())));
      } catch (NumberFormatException ex) {
         System.err.println("Error while parse to binary." + ex.toString());
      }
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

   /**
    * @Author Lampros Giotis
    * This method implements the contrast function.It switches the colours of the buttons as well as
    * the panels to make it more contrast.When pressed again it switches back to normal
    */
   public void contrastButton(){
      if(colourCounter == false){//The button has not been pressed.Therfor the starting value remains the same as the initiliazed
         panel.setBackground(Color.black);//////
         panelSub1.setBackground(Color.black);//
         panelSub2.setBackground(Color.black);//
         panelSub3.setBackground(Color.black);//////Adjusting the black colour to the panels first
         panelSub4.setBackground(Color.black);//
         panelSub5.setBackground(Color.black);//
         panelSub6.setBackground(Color.black);//
         panelSub7.setBackground(Color.black);//
         panelSub8.setBackground(Color.black);//

         //We also change the contrast of the buttons.
         for (int i = 0; i < 11; i++) {
            but[i].setBackground(Color.white);
            but[i].setForeground(Color.black);
         }
         //==========================================================================
         butabs.setBackground(Color.white);//We change the colours on the butabs button
         butabs.setForeground(Color.black);
         //======================================================================
         butContrast.setBackground(Color.white);//We change the colours on the contrast button
         butContrast.setForeground(Color.black);
         //======================================================================
         butCancel.setBackground(Color.white);//We change the colours on the cancel button
         butCancel.setForeground(Color.black);
         //======================================================================
         butAdd.setBackground(Color.white);//We change the colours on the add button
         butAdd.setForeground(Color.black);
         //======================================================================
         butTan.setBackground(Color.white);//We change the colours on the tan button
         butTan.setForeground(Color.black);
         //======================================================================
         butDivide.setBackground(Color.white);//We change the colours on the divide button
         butDivide.setForeground(Color.black);
         //======================================================================
         butSin.setBackground(Color.white);//We change the colours on the sin button
         butSin.setForeground(Color.black);
         //======================================================================
         butSquare.setBackground(Color.white);//We change the colours on the square button
         butSquare.setForeground(Color.black);
         //======================================================================
         butSquareRoot.setBackground(Color.white);//We change the colours on the squareroot button
         butSquareRoot.setForeground(Color.black);
         //======================================================================
         butEqual.setBackground(Color.white);//We change the colours on the equal button
         butEqual.setForeground(Color.black);
         //=======================================================================
         butMinus.setBackground(Color.white);//We change the colours on the minus button
         butMinus.setForeground(Color.black);
         //=======================================================================
         butMultiply.setBackground(Color.white);//We change the colours on the multiply button
         butMultiply.setForeground(Color.black);
         //=======================================================================
         butCos.setBackground(Color.white);//We change the colours on the cos button
         butCos.setForeground(Color.black);
         //=======================================================================
         butxpowerofy.setBackground(Color.white);//We change the colours on the powerofy button
         butxpowerofy.setForeground(Color.black);
         //=======================================================================
         butlog.setBackground(Color.white);//We change the colours on the log button
         butlog.setForeground(Color.black);
         //=======================================================================
         butrate.setBackground(Color.white);//We change the colours on the rate button
         butrate.setForeground(Color.black);
         //=======================================================================
         butln.setBackground(Color.white);//We change the colours on the ln button
         butln.setForeground(Color.black);
         //=======================================================================
         butBinary.setBackground(Color.white);//We change the colours on the binary button
         butBinary.setForeground(Color.black);
         //Finally...
         colourCounter = true;//We set the button to true as the action listener has been enabled and the colour is changed to black
      }else if(colourCounter == true){//The button is pressed
         panel.setBackground(Color.lightGray);
         panelSub1.setBackground(Color.lightGray);
         panelSub2.setBackground(Color.lightGray);
         panelSub3.setBackground(Color.lightGray);
         panelSub4.setBackground(Color.lightGray);
         panelSub5.setBackground(Color.lightGray);
         panelSub6.setBackground(Color.lightGray);
         panelSub7.setBackground(Color.lightGray);
         panelSub8.setBackground(Color.lightGray);
         //We also change the contrast of the buttons.
         for (int i = 0; i < 11; i++) {
            but[i].setBackground(Color.white);
            but[i].setForeground(Color.black);
         }
         //=====================================================================
         butabs.setBackground(Color.white);//We change the colours on the butabs button
         butabs.setForeground(Color.black);
         //======================================================================
         butContrast.setBackground(Color.white);//We change the colours on the contrasts button
         butContrast.setForeground(Color.black);
         //======================================================================
         butCancel.setBackground(Color.white);//we change the colour on the cancel button
         butCancel.setForeground(Color.black);
         //======================================================================
         butAdd.setBackground(Color.white);//we change the colour on add button
         butAdd.setForeground(Color.black);
         //======================================================================
         butTan.setBackground(Color.white);//we change the colour of the tan button
         butTan.setForeground(Color.black);
         //======================================================================
         butDivide.setBackground(Color.white);//we  change the clour of the division button
         butDivide.setForeground(Color.black);
         //======================================================================
         butSin.setBackground(Color.white);//we change the colour of the sin button
         butSin.setForeground(Color.black);
         //======================================================================
         butSquare.setBackground(Color.white);//we change the colour of the square button
         butSquare.setForeground(Color.black);
         //======================================================================
         butSquareRoot.setBackground(Color.white);//we change the colour the squareroot button
         butSquareRoot.setForeground(Color.black);
         //======================================================================
         butOneDividedBy.setBackground(Color.white);//we change the colour of the deivideby button
         butOneDividedBy.setForeground(Color.black);
         //======================================================================
         butEqual.setBackground(Color.white);//we change the colour of the equal button
         butEqual.setForeground(Color.black);
         //=======================================================================
         butMinus.setBackground(Color.white);//we change the colour of the minus button
         butMinus.setForeground(Color.black);
         //=======================================================================
         butMultiply.setBackground(Color.white);//we change the colour of the multiply button
         butMultiply.setForeground(Color.black);
         //=======================================================================
         butCos.setBackground(Color.white);//we change the colour of the cos button
         butCos.setForeground(Color.black);
         //=======================================================================
         butxpowerofy.setBackground(Color.white);//we change the colour of the powerofy button
         butxpowerofy.setForeground(Color.black);
         //=======================================================================
         butlog.setBackground(Color.white);//we change the colour of the log button
         butlog.setForeground(Color.black);
         //=======================================================================
         butrate.setBackground(Color.white);//we change the colour of the rate button
         butrate.setForeground(Color.black);
         //=======================================================================
         butln.setBackground(Color.white);//we change the colour of the ln button
         butln.setForeground(Color.black);
         //=======================================================================
         butCancel.setBackground(Color.white);//we change the colour of the cancel button
         butCancel.setForeground(Color.black);
         //=======================================================================
         butBinary.setBackground(Color.white);//we change the colour of the binary button
         butBinary.setForeground(Color.black);
         colourCounter = false;//We change the value back to false in order to suppose
         // in some way that the next time the button is pressed,it should change back to black colour.

      }
   }

}
