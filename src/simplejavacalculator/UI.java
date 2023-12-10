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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon; 
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UI implements ActionListener {
	
	private final JFrame 	frame;
	private final JPanel 	panel, panelSub1, panelSub2, panelSub3, panelSub4, panelSub5, 
   							panelSub6, panelSub7, panelSub8;
	private final JTextArea text;
	private final JButton 	butZero, butOne, butTwo, butThree, butFour, butFive, butSix, 
   							butSeven, butEight, butNine,
   							butAdd, butMinus, butMultiply, butDivide,
      						butEqual, butCancel, butSquareRoot, butSquare, butOneDividedBy,
      						butCos, butSin, butTan, butxpowerofy, butlog, butrate, butabs, 
      						butBinary, butln;
	private final Font 		font;
    private final Font 		textFont;
    private ImageIcon 		image;
    private BufferedImageCustom imageReturn;
   
    public Map<JButton, Command> ButtonCommandMap = new HashMap<JButton, Command>();
    public Map<JButton, String> ButtonLabelMap = new HashMap<JButton, String>();
    public Map<JButton, Calculator> ButtonCalcMap = new HashMap<JButton, Calculator>();
    
    public Buffer buffer = new Buffer();
   
    //CONSTRUCTOR
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
     
        //MAPPED ACTION BUTTONS:
        butZero 		= newJButton_map_variable("0", 		new NumberCommand(), 	null); 
        butOne 			= newJButton_map_variable("1", 		new NumberCommand(), 	null); 
        butTwo 			= newJButton_map_variable("2", 		new NumberCommand(), 	null);
        butThree 		= newJButton_map_variable("3", 		new NumberCommand(), 	null);
        butFour 		= newJButton_map_variable("4", 		new NumberCommand(), 	null);
        butFive 		= newJButton_map_variable("5", 		new NumberCommand(), 	null); 
        butSix 			= newJButton_map_variable("6", 		new NumberCommand(), 	null);
        butSeven 		= newJButton_map_variable("7", 		new NumberCommand(), 	null);
        butEight 		= newJButton_map_variable("8", 		new NumberCommand(), 	null);
        butNine 		= newJButton_map_variable("9", 		new NumberCommand(), 	null);
        butAdd 			= newJButton_map_variable("+", 		new BinaryCommand(), 	new AddCalc());      
        butMinus 		= newJButton_map_variable("-", 		new BinaryCommand(), 	new MinusCalc());      
        butMultiply 	= newJButton_map_variable("*", 		new BinaryCommand(), 	new MultiplyCalc());      
        butDivide 		= newJButton_map_variable("/", 		new BinaryCommand(), 	new DivideCalc());      
        butEqual 		= newJButton_map_variable("=", 		new EqualCommand(), 	null);      
        butSquareRoot 	= newJButton_map_variable("sqrt", 	new UnaryCommand(), 	new SquareRootCalc());      
        butSquare 		= newJButton_map_variable("x*x", 	new UnaryCommand(), 	new SquareCalc());      
        butOneDividedBy = newJButton_map_variable("1/x", 	new UnaryCommand(), 	new OneDivideByCalc());      
        butCos 			= newJButton_map_variable("Cos", 	new UnaryCommand(), 	new CosCalc());      
        butSin 			= newJButton_map_variable("Sin", 	new UnaryCommand(), 	new SinCalc());      
        butTan 			= newJButton_map_variable("Tan", 	new UnaryCommand(), 	new TanCalc());      
        butln 			= newJButton_map_variable("ln", 	new UnaryCommand(), 	new LnCalc());     
        butxpowerofy 	= newJButton_map_variable("x^y", 	new UnaryCommand(), 	new XpowerofyCalc());      
        butlog 			= newJButton_map_variable("log10(x)", new UnaryCommand(), 	new LogCalc());      
        butrate 		= newJButton_map_variable("x%", 	new UnaryCommand(), 	new RateCalc());      
        butabs 			= newJButton_map_variable("abs(x)", new UnaryCommand(), 	new AbsCalc());      
        butCancel 		= newJButton_map_variable("C", 		new ClearCommand(), 	null);      
        butBinary 		= newJButton_map_variable("Bin", 	null, null);
      
        this.emplace_widgets(); // Discussion ??
   }
   
   //MAPPER:
   private JButton newJButton_map_variable(String label, Command op, Calculator calc)
   {
	   JButton button = new JButton(label);
	   
	   ButtonCommandMap.put(button, op);
	   ButtonLabelMap.put(button, label);
	   ButtonCalcMap.put(button, calc);
	   
	   button.setFont(font);
	   button.addActionListener(this);
	   
	   return button;
   }
   
   //J-TEXT-AREA METHODS:
   private void parsetoBinary() {
	      try {
	         text.setText("" + Long.toBinaryString(Long.parseLong(text.getText())));
	      } catch (NumberFormatException ex) {
	         System.err.println("Error while parse to binary." + ex.toString());
	      }
   }
   
   public void emplace_widgets() {      
       frame.setSize(450, 450);
       frame.setLocationRelativeTo(null); 
       frame.setResizable(false);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setIconImage(image.getImage());
       text.setFont(textFont);
       text.setEditable(false);
      
       panel.add(Box.createHorizontalStrut(100));
       panelSub1.add(text);
       panel.add(panelSub1);
      
       panelSub2.add(butOne);
       panelSub2.add(butTwo);
       panelSub2.add(butThree);
       panelSub2.add(Box.createHorizontalStrut(15));
       panelSub2.add(butAdd);
       panelSub2.add(butMinus);
       panel.add(panelSub2);
      
       panelSub3.add(butFour);
       panelSub3.add(butFive);
       panelSub3.add(butSix);
       panelSub3.add(Box.createHorizontalStrut(15));
       panelSub3.add(butMultiply);
       panelSub3.add(butDivide);      
       panel.add(panelSub3);
      
       panelSub4.add(butSeven);
       panelSub4.add(butEight);
       panelSub4.add(butNine);
       panelSub4.add(Box.createHorizontalStrut(15));
       panelSub4.add(butEqual);
       panelSub4.add(butCancel);
       panel.add(panelSub4);
      
       panelSub5.add(Box.createHorizontalStrut(92));
       panelSub5.add(butZero);
       panelSub5.add(butln); 
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
      
       frame.add(panel);
       frame.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
	   final Object 	button = e.getSource();
	   String 			label = (ButtonLabelMap.get(button));
	   Command 			cm = (ButtonCommandMap.get(button)); 
	   Calculator		calc = (ButtonCalcMap.get(button));

	   
	   Command.writer(Double.NaN, text); 	// CLEAR SCREEN IN EVERY ACTION

	   cm.execute(buffer, label); 			// POLYMORPHIC EXECUTE COMMAND
	   
	   cm.show(text, buffer, calc, label); 	// POLYMORPHIC SHOW COMMAND
   }
}