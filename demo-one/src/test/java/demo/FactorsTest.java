package demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FactorsTest {
	
	@Test
	public void test1() {
		assertEquals(4,Factors.getFactorsCount(27));
	}

}
