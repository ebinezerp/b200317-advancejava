package demo;

import java.util.Scanner;

public class Factorial {

	public static int getFactorial(int num) {
		int fact = 1;

		while (num > 0) {
			fact = fact * num--;
		}

		return fact;

	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int num = scanner.nextInt();

		getFactorial(3);
		getFactorial(5);

	}

}
