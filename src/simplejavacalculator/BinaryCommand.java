package simplejavacalculator;

import javax.swing.JTextArea;

import simplejavacalculator.Buffer.PreviouslyPressed;

public class BinaryCommand extends Command {

	public void execute(Buffer buffer, String label) {
		this.sub = CommandSubtype.COM_BINARY;
		Buffer.pp = PreviouslyPressed.PRESSED_BINARY;
		// Calculation with an abstraction manner
	}
		
	public void show(JTextArea text, Buffer buffer, Calculator calc, String label) {
		buffer.c = calc; // save the pointer globally
		text.setText(label);
		   if (buffer.c != null && (buffer.num1 != null && buffer.num2 != null)) {
			   buffer.num1 = (calc.calculate(buffer));
			   writer(buffer.num1, text);
		   }
	}
}
