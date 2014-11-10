package ph.calculator;

import static org.junit.Assert.*;

import java.awt.Frame;
import java.awt.Robot;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UITest {
	private UI Ui;
	@Before
	public void setUp() throws Exception {
		Ui = new UI();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUI() {
		
	}
	
	@Test
	public void testInit() {
		org.junit.Assert.assertNotNull(Ui);
		Ui.init();
		JFrame frame = Ui.frame;
		assertNotNull(frame);
		assertTrue(frame.isVisible());
		assertEquals(250, frame.getHeight());
		assertEquals(250, frame.getWidth());
		assertEquals(JFrame.EXIT_ON_CLOSE, frame.getDefaultCloseOperation());
	}
	
	@Test
	public void testActionPerformed() {
		ActionEvent e = new ActionEvent(Ui.but0, 1, null);
		Ui.actionPerformed(e);
		assertEquals(0, Ui.reader(), 0);
	}
	
	@Test
	public void testReader() {
		
	}

}
