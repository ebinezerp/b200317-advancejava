package demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FactorialTest {

	@Test
	public void test1() {
		int result = Factorial.getFactorial(5);
		assertEquals(120, result);
	}

	@Test
	public void test2() {
		int result = Factorial.getFactorial(3);
		assertEquals(6, result);
	}

	@Test
	public void test3() {
		int result = Factorial.getFactorial(-4);
		assertEquals(1, result);
	}
}
