package demo1;



import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;



public class PrimeNumberTest {
	
	@Test
	public void test1() {
		
		boolean result =PrimeNumber.isPrime(7);
		assertTrue(result);
		
	}

}
