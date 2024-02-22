package com.codemistri.Step1;

public class Basic_recursion {

	public static void main(String[] args) {
		printSum(6, new int[1]);

	}

	// Print your Name N times using recursion
	private static void printName(int n) {
		if (n == 0)
			return;

		System.out.print("Pankaj ");
		n--;
		printName(n);

	}

	// Print from 1 to N using Recursion
	private static void print1_to_N(int n, int start) {
		System.out.print(start + " ");
		if (start == n)
			return;
		start++;
		print1_to_N(n, start);

	}

	// Print from N to 1 using Recursion
	private static void printN_to_1(int n) {
		System.out.print(n + " ");
		if (n == 1)
			return;
		printN_to_1(n - 1);

	}

	/*
	 * Given a number N find out the sum of the first N natural numbers. Example 1:
	 * Input: N=5 Output: 15 Explanation: 1+2+3+4+5=15
	 */

	private static void printSum(int n, int[] result) {
		if (n < 1) {
			System.out.println(result[0]);
			return;
		}
		result[0] = result[0] + n;
		n--;
		printSum(n, result);

	}

}
