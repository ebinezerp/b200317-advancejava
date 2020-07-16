package demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FirstFivePrimeNumbersTest {

	@Test
	void test() {
		int[] primes = FirstFivePrimeNumbers.getPrimes(1);
		int[] expected = new int[] {1,2,3,5,7};
		
		assertArrayEquals(expected, primes);
	}
	
	@Test
	void test2() {
		int[] primes = FirstFivePrimeNumbers.getPrimes(17);
		int[] expected = new int[] {17,19,23,29,31};
		
		assertArrayEquals(expected, primes);
	}

}
