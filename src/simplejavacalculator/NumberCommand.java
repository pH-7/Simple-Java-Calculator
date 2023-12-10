package simplejavacalculator;

import javax.swing.JTextArea;

import simplejavacalculator.Buffer.PreviouslyPressed;

public class NumberCommand extends Command {
	
	private double get_new_buff_after_num_pressed(Double buffer, Double new_num)
	{
		Double res = null;
		
		Double temp2 	= (double)(buffer * 10 + new_num);
		
		if (temp2 < Integer.MAX_VALUE) {
			res = temp2;
		}
		return res; 
	}
	
	public void execute(Buffer buffer, String label) {
		
		this.sub = CommandSubtype.COM_NUMBER;
		
		Double temp1 = Double.parseDouble(label);
		
		if (Buffer.pp == PreviouslyPressed.PRESSED_NONE || Buffer.pp == PreviouslyPressed.PRESSED_EQUAL) {
			buffer.num1 = temp1;
			Buffer.pp = PreviouslyPressed.PRESSED_NUMBER;
		} else if (Buffer.pp == PreviouslyPressed.PRESSED_NUMBER) {
			if (buffer.num2 != null) {
				buffer.num2 = get_new_buff_after_num_pressed(buffer.num2, temp1);
			} else {
				buffer.num1 = get_new_buff_after_num_pressed(buffer.num1, temp1);
			}
		} else  if (Buffer.pp == PreviouslyPressed.PRESSED_BINARY) {
			buffer.num2 = temp1;
			Buffer.pp = PreviouslyPressed.PRESSED_NUMBER;
		}
	}
	
	public void show(JTextArea text, Buffer buffer, Calculator calc, String label) {
		if (buffer.num2 != null) {
			writer((double)buffer.num2, text);
		} else {
			writer((double)buffer.num1, text);
		}
	}
}
