package demo;

public class Factors {

	public static int getFactorsCount(int num) {
		int count = 0;
		for (int div = 1; div <= num; div++) {
			if (num % div == 0) {
				count++;
			}
		}
		return count;
	}

}
