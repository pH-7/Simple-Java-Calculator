package simplejavacalculator;

import javax.swing.JTextArea;

import simplejavacalculator.Buffer.PreviouslyPressed;

public class UnaryCommand extends Command {

	public void execute(Buffer buffer, String label) {
		this.sub = CommandSubtype.COM_UNARY;
		Buffer.pp = PreviouslyPressed.PRESSED_UNARY;
	}
	
	public void show(JTextArea text, Buffer buffer, Calculator calc, String label) {
		if (calc != null) {
			buffer.num1 = calc.calculate(buffer);
			writer(buffer.num1, text);
		}
	}
}
