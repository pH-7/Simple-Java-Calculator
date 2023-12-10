package simplejavacalculator;

import javax.swing.JTextArea;

import simplejavacalculator.Buffer.PreviouslyPressed;

public class EqualCommand extends Command {
	public void execute(Buffer buffer, String label) {
		this.sub = CommandSubtype.COM_EQUAL;
		Buffer.pp = PreviouslyPressed.PRESSED_EQUAL;
	}
	
	public void show(JTextArea text, Buffer buffer, Calculator calc, String label) {
		 if (buffer.c != null && (buffer.num1 != null && buffer.num2 != null)) {
			   buffer.num1 = ((Calculator)(buffer.c)).calculate(buffer);
			   writer(buffer.num1, text);
			   buffer.num2 = null;
	
		 }
	}
}