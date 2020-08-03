package demo1;

public class PrimeNumber {

	public static boolean isPrime(int num) {
		for (int div = 2; div <= num / 2; div++) {
			if (num % div == 0) {
				return false;
			}
		}
		return true;
	}

}
