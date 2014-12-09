package negPack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NegadecimalCalculatorTest {
	NegadecimalCalculator n;

	@Before
	public void setUp() throws Exception {
		n = new NegadecimalCalculator();
	}

	@Test
	public void testEvaluate() {
		// evaluate("user input", "current number saved")
		assertEquals("Done.", n.evaluate("q", "0"));
		assertEquals("Done.", n.evaluate("quit", "5"));
		assertEquals("Done.", n.evaluate("Quit", "2"));
		assertEquals("Done.", n.evaluate("QuIt ", "2"));

		assertEquals("Error", n.evaluate("hi", "Error"));
		assertEquals("Error", n.evaluate("", "Error"));
		assertEquals("Error", n.evaluate(" ", "Error"));
		assertEquals("Error", n.evaluate("2", "Error"));
		assertEquals("Error", n.evaluate("0", "Error"));
		
		assertEquals("0", n.evaluate("c", "Error"));
		assertEquals("0", n.evaluate("clear", "2"));
		assertEquals("0", n.evaluate("C", "4"));
		assertEquals("0", n.evaluate("ClEaR ", "4"));

		assertEquals("Error", n.evaluate("hi", "5"));
		assertEquals("Error", n.evaluate("", "5"));
		assertEquals("Error", n.evaluate("2.5", "0"));
		assertEquals("Error", n.evaluate("decimal 2n", "0"));
		
		assertEquals("2", n.evaluate("2", "0"));
		assertEquals("4", n.evaluate("+2", "2"));
		assertEquals("4", n.evaluate("+ 2", "2"));
		assertEquals("2", n.evaluate("-2", "4"));
		assertEquals("6", n.evaluate("*2", "3"));
		assertEquals("4", n.evaluate("/2", "8"));
		assertEquals("Error - Divide by zero", n.evaluate("/0", "8"));
		assertEquals("Error - Divide by zero", n.evaluate("%0", "8"));
		
		assertEquals("10 (decimal -10)", n.evaluate("?", "10"));
		assertEquals("0 (decimal 0)", n.evaluate("?", "0"));
		assertEquals("12 (decimal -8)", n.evaluate("?", "12"));
		
		assertEquals("190", n.evaluate("~", "10"));
		assertEquals("10", n.evaluate("~", "190"));
		assertEquals("0", n.evaluate("~", "0"));
		assertEquals("4", n.evaluate("~", "16"));
}

}
