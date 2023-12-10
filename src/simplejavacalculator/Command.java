package simplejavacalculator;

import javax.swing.JTextArea;

public abstract class Command {
	
	public enum CommandSubtype {
		COM_NUMBER,
		COM_UNARY,
		COM_BINARY,
		COM_EQUAL,
		COM_CLEAR
	}
	
	public CommandSubtype sub;
	
	public abstract void execute(Buffer buffer, String label);
	public abstract void show(JTextArea text, Buffer buffer, Calculator calc, String label);
	
	public static void writer(final Double num, JTextArea text) {
	   if (Double.isNaN(num)) {
		   text.setText("");
	   } else {
		   text.setText(Double.toString(num));
	   }
   }
}
