package simplejavacalculator;

import javax.swing.JTextArea;

import simplejavacalculator.Buffer.PreviouslyPressed;

public class ClearCommand extends Command{
	public void execute(Buffer buffer, String label) {
		this.sub = CommandSubtype.COM_CLEAR;

		Buffer.pp = PreviouslyPressed.PRESSED_NONE;
		buffer.num1 = null;
		buffer.num2 = null;
	}
	
	public void show(JTextArea text, Buffer buffer, Calculator calc, String label) {
		 writer(Double.NaN, text);
	}
}
