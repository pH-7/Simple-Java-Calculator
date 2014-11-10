package ph.calculator;

import static org.junit.Assert.*;

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
		
	}
	
	@Test
	public void testActionPerformed() {
		
	}
	
	@Test
	public void testReader() {
		
	}

}
