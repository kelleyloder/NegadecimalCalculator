package negPack;

import static org.junit.Assert.*;

import org.junit.Test;

public class NegadecimalNumberTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void testNegadecimalNumberString() throws Exception {
        
        NegadecimalNumber ndn1 = new NegadecimalNumber("17");
        assertEquals(-3, ndn1.valueDec);
        assertEquals("17", ndn1.valueNdn);
        
        // This one throws exception
        NegadecimalNumber ndn2 = new NegadecimalNumber("abc");
        
        // These assertions are never run because Exception was caught
        assertEquals(-3, ndn2.valueDec);
        assertTrue(false);
        assertFalse(true);
	}

	@Test
	public void testNegadecimalNumberInt() {
		NegadecimalNumber ndn1 = new NegadecimalNumber(-3);
        assertEquals("17", ndn1.valueNdn);
        assertEquals(-3, ndn1.valueDec);
	}

	@Test
	public void testAdd() {
		NegadecimalNumber operandOne = new NegadecimalNumber(5);
		NegadecimalNumber operandTwo = new NegadecimalNumber(1);
		NegadecimalNumber expectedOut = new NegadecimalNumber(6);
		assertEquals(expectedOut, operandOne.add(operandTwo));
		
		operandOne = new NegadecimalNumber(10);
		operandTwo = new NegadecimalNumber(-10);
		expectedOut = new NegadecimalNumber(0);
		assertEquals(expectedOut, operandOne.add(operandTwo));
		
		operandOne = new NegadecimalNumber(-1000);
		operandTwo = new NegadecimalNumber(-111);
		expectedOut = new NegadecimalNumber(-1111);
		assertEquals(expectedOut, operandOne.add(operandTwo));
		
		operandOne = new NegadecimalNumber(0);
		operandTwo = new NegadecimalNumber(1);
		expectedOut = new NegadecimalNumber(1);
		assertEquals(expectedOut, operandOne.add(operandTwo));
	}

	@Test
	public void testSubtract() {
		NegadecimalNumber operandOne = new NegadecimalNumber(5);
		NegadecimalNumber operandTwo = new NegadecimalNumber(1);
		NegadecimalNumber expectedOut = new NegadecimalNumber(4);
		assertEquals(expectedOut, operandOne.subtract(operandTwo));
		
		operandOne = new NegadecimalNumber(10);
		operandTwo = new NegadecimalNumber(-10);
		expectedOut = new NegadecimalNumber(20);
		assertEquals(expectedOut, operandOne.subtract(operandTwo));
		
		operandOne = new NegadecimalNumber(-1000);
		operandTwo = new NegadecimalNumber(9);
		expectedOut = new NegadecimalNumber(-1009);
		assertEquals(expectedOut, operandOne.subtract(operandTwo));
		
		operandOne = new NegadecimalNumber(0);
		operandTwo = new NegadecimalNumber(1);
		expectedOut = new NegadecimalNumber(-1);
		assertEquals(expectedOut, operandOne.subtract(operandTwo));
	}

	@Test
	public void testMultiply() {
		NegadecimalNumber operandOne = new NegadecimalNumber(5);
		NegadecimalNumber operandTwo = new NegadecimalNumber(1);
		NegadecimalNumber expectedOut = new NegadecimalNumber(5);
		assertEquals(expectedOut, operandOne.multiply(operandTwo));
		
		operandOne = new NegadecimalNumber(10);
		operandTwo = new NegadecimalNumber(-10);
		expectedOut = new NegadecimalNumber(-100);
		assertEquals(expectedOut, operandOne.multiply(operandTwo));
		
		operandOne = new NegadecimalNumber(-1000);
		operandTwo = new NegadecimalNumber(9);
		expectedOut = new NegadecimalNumber(-9000);
		assertEquals(expectedOut, operandOne.multiply(operandTwo));
		
		operandOne = new NegadecimalNumber(0);
		operandTwo = new NegadecimalNumber(1);
		expectedOut = new NegadecimalNumber(0);
		assertEquals(expectedOut, operandOne.multiply(operandTwo));
	}

	@Test(expected = ArithmeticException.class)
	public void testDivide() throws Exception {
		NegadecimalNumber operandOne = new NegadecimalNumber(-5);
		NegadecimalNumber operandTwo = new NegadecimalNumber(1);
		NegadecimalNumber expectedOut = new NegadecimalNumber(-5);
		assertEquals(expectedOut, operandOne.divide(operandTwo));
		
		operandOne = new NegadecimalNumber(91);
		operandTwo = new NegadecimalNumber(-10);
		expectedOut = new NegadecimalNumber(-9);
		assertEquals(expectedOut, operandOne.divide(operandTwo));
		
		operandOne = new NegadecimalNumber(3);
		operandTwo = new NegadecimalNumber(4);
		expectedOut = new NegadecimalNumber(0);
		assertEquals(expectedOut, operandOne.divide(operandTwo));
		
		operandOne = new NegadecimalNumber(0);
		operandTwo = new NegadecimalNumber(1);
		expectedOut = new NegadecimalNumber(0);
		assertEquals(expectedOut, operandOne.divide(operandTwo));
		
		operandOne = new NegadecimalNumber(9);
		operandTwo = new NegadecimalNumber(0);
		// This one throws exception
		operandOne.divide(operandTwo);
		
		// These assertions are never run because Exception was caught
        assertTrue(false);
        assertFalse(true);
	}

	@Test(expected = ArithmeticException.class)
	public void testRemainder() throws Exception {
		NegadecimalNumber operandOne = new NegadecimalNumber(-5);
		NegadecimalNumber operandTwo = new NegadecimalNumber(1);
		NegadecimalNumber expectedOut = new NegadecimalNumber(0);
		assertEquals(expectedOut, operandOne.remainder(operandTwo));
		
		operandOne = new NegadecimalNumber(91);
		operandTwo = new NegadecimalNumber(-10);
		expectedOut = new NegadecimalNumber(1);
		assertEquals(expectedOut, operandOne.remainder(operandTwo));
		
		operandOne = new NegadecimalNumber(3);
		operandTwo = new NegadecimalNumber(4);
		expectedOut = new NegadecimalNumber(3);
		assertEquals(expectedOut, operandOne.remainder(operandTwo));
		
		operandOne = new NegadecimalNumber(0);
		operandTwo = new NegadecimalNumber(1);
		expectedOut = new NegadecimalNumber(0);
		assertEquals(expectedOut, operandOne.remainder(operandTwo));
		
		operandOne = new NegadecimalNumber(9);
		operandTwo = new NegadecimalNumber(0);
		// This one throws exception
		operandOne.remainder(operandTwo);
		
		// These assertions are never run because Exception was caught
        assertTrue(false);
        assertFalse(true);
	}

	@Test
	public void testNegate() {
		NegadecimalNumber operand = new NegadecimalNumber(-5);
		NegadecimalNumber expectedOut = new NegadecimalNumber(5);
		assertEquals(expectedOut, operand.negate());
		
		operand = new NegadecimalNumber(91);
		expectedOut = new NegadecimalNumber(-91);
		assertEquals(expectedOut, operand.negate());
		
		operand = new NegadecimalNumber(300);
		expectedOut = new NegadecimalNumber(-300);
		assertEquals(expectedOut, operand.negate());
		
		operand = new NegadecimalNumber(0);
		expectedOut = new NegadecimalNumber(0);
		assertEquals(expectedOut, operand.negate());
	}

	@Test
	public void testDecimalValue() {
		NegadecimalNumber operandOne = new NegadecimalNumber("17");
		assertEquals(-3, operandOne.decimalValue());
		
		operandOne = new NegadecimalNumber("5");
		assertEquals(5, operandOne.decimalValue());
		
		operandOne = new NegadecimalNumber("71025");
		assertEquals(68985, operandOne.decimalValue());
		
		operandOne = new NegadecimalNumber(20);
		assertEquals(20, operandOne.decimalValue());
	}
	
	@Test
	public void testNegadecimalValue() {
		NegadecimalNumber operandOne = new NegadecimalNumber(-3);
		assertEquals("17", operandOne.negadecimalValue());
		
		operandOne = new NegadecimalNumber("5");
		assertEquals("5", operandOne.negadecimalValue());
		
		operandOne = new NegadecimalNumber(68985);
		assertEquals("71025", operandOne.negadecimalValue());
		
		operandOne = new NegadecimalNumber(0);
		assertEquals("0", operandOne.negadecimalValue());
	}

	@Test
	public void testToString() {
		NegadecimalNumber operand = new NegadecimalNumber(68985);
		assertEquals("71025", operand.toString());
		
		operand = new NegadecimalNumber(-3);
		assertEquals("17", operand.toString());
		
		operand = new NegadecimalNumber(0);
		assertEquals("0", operand.toString());
		
		operand = new NegadecimalNumber(8163);
		assertEquals("12243", operand.toString());
	}

	@Test
	public void testEquals() {
		NegadecimalNumber operandOne = new NegadecimalNumber(-5);
		NegadecimalNumber operandTwo = new NegadecimalNumber(1);
		assertFalse(operandOne.equals(operandTwo));
		
		operandOne = new NegadecimalNumber(1);
		operandTwo = new NegadecimalNumber(1);
		assertTrue(operandOne.equals(operandTwo));
		
		operandOne = new NegadecimalNumber("71025");
		operandTwo = new NegadecimalNumber(68985);
		assertTrue(operandOne.equals(operandTwo));
		
		operandOne = new NegadecimalNumber("71025");
		operandTwo = new NegadecimalNumber(71025);
		assertFalse(operandOne.equals(operandTwo));
	}
}
