package com.aslinformationservices.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
	private static final double DELTA = 1e-15;

	@Test
	void testAdd() {
		Calculator calculator = new Calculator();
		assertEquals(5.0, calculator.add(2.0, 3.0), DELTA);
		assertEquals(-1.0, calculator.add(-2.0, 1.0), DELTA);
		assertEquals(0.0, calculator.add(0.0, 0.0), DELTA);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			fail("Test interrupted");
		}
	}

}
