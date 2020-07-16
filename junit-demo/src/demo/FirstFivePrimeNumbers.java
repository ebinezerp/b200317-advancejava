package demo;

public class FirstFivePrimeNumbers {

	public static int[] getPrimes(int givenNum) {
		int primeCount = 0;
		
		int[] primeNums = new int[5]; 
		
		for (int num = givenNum; primeCount < 5; num++) {
			if(isPrime(num)) {
				primeNums[primeCount++] = num;
			}
		}
		return primeNums;
	}

	public static boolean isPrime(int num){
		
		for(int div=2;div<num;div++) {
			if(num%div==0) {
				return false;
			}
		}
		return true;
	}

}
