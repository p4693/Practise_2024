/**
 * 
 */
package com.codemistri.Step1;

/**
 * @author PankajS
 *
 */
public class KnowBasicMaths {

	public static void main(String[] args) {
		System.out.println(checkPrime(1));
	}

//	Given an integer N, write a program to count the number of digits in N.
	private static void findNoOfDigits1() {
		int num = 15679;
		int count = 0;
		while (num != 0) {
			count++;
			num = num / 10;
		}
		System.out.println(count);
	}

	private static void findNoOfDigits2() {
		int num = 15679;
		String num1 = Integer.toString(num);
		System.out.println(num1.length());
	}

	/*
	 * Example : The number of digits in an integer = the upper bound of log10(n). n
	 * = 12345 log10(12345) = 4.091 Integral part of 4.091 is 4 and 4 + 1 = 5 which
	 * is also the number of digits in 12345
	 */
	private static void findNoOfDigits3() {
		int num = 15679;
		int digits = (int) Math.floor(num);
		System.out.println(digits);
	}

	// *************************************************************************************

	// Given a number N reverse the number and print it
	// Explanation: The reverse of 123 is 321

	private static void printReverse() {
		int num = 12345;
		int reverseNum = 0;
		while (num != 0) {
			int digit = num % 10;
			reverseNum = reverseNum * 10 + digit;
			num = num / 10;
		}
		System.out.println(reverseNum);

	}

	// *************************************************************************************

	/*
	 * Given a number check if it is a palindrome.An integer is considered a
	 * palindrome when it reads the same backward as forward. 121 read backwards as
	 * 121.Since these are two same numbers 121 is a palindrome.
	 */
	private static void checkPalindrome() {
		int num = 1213;
		String numStr = Integer.toString(num);
		boolean result = false;
		int i = 0;
		int j = numStr.length() - 1;
		while (i < j) {
			if (numStr.charAt(i) == numStr.charAt(j)) {
				result = true;
			}
			i++;
			j--;
		}
		System.out.println(result);

	}

	private static void checkPalindrome1(int num) {
		int reverseNum = 0;
		while (num > 0) {
			int digit = num % 10;
			reverseNum = reverseNum * 10 + digit;
			num = num / 10;
		}
		System.out.println(num == reverseNum);

	}
	// *************************************************************************************

	/* Find the gcd (greatest common deviser)of two numbers */

	private static void findGcd() {
		int num1 = 12, num2 = 9;

		for (int i = Math.min(num1, num2); i > 0; i--) {
			if (num1 % i == 0 && num2 % i == 0) {
				System.out.println("GCD is: " + i);
				break;
			}

		}
	}

//	Optimal approach VImp Url-https://takeuforward.org/data-structure/find-gcd-of-two-numbers/
	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	// *************************************************************************************

	/*
	 * Given a number, check if it is Armstrong Number or Not..An integer is
	 * considered a Armstrong Numbers are the numbers having the sum of digits
	 * raised to power no. of digits is equal to a given number 1^3 + 5^3 + 3^3 =153
	 * it is an Armstrong Number. 1^4+6^4+3^4+4^4=1634 it is an Armstrong Number
	 */
	private static void checkArmstrong() {
		int num = 16345;
		int digitCount = 0;
		int temp = num;
		int sum = 0;
		while (temp != 0) {
			digitCount++;
			temp = temp / 10;

		}
		temp = num;
		while (temp != 0) {
			int digit = temp % 10;
			sum = sum + (int) Math.pow(digit, digitCount);
			temp = temp / 10;
		}
		if (sum == num) {
			System.out.println("Armstrong");
		} else {
			System.out.println(" Not Armstrong");
		}

	}

	// *************************************************************************************

	/*
	 * Given a number, print all the divisors of the number. A divisor is a number
	 * that gives the remainder as zero when divided. Example 1: Input: n = 36
	 * Output: 1 2 3 4 6 9 12 18 36 Explanation: All the divisors of 36 are printed.
	 */
	private static void printAllDivisers() {
		int n = 36;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				System.out.print(i + ",");
			}
		}

	}

	// optimal Approach VImp

	/*
	 * If we take a closer look, we can notice that the quotient of a division by
	 * one of the divisors is actually another divisor. Like, 4 divides 36. The
	 * quotient is 9, and 9 also divides 36. Another intuition is that the root of a
	 * number actually acts as a splitting part of all the divisors of a number.
	 */
	private static void printAllDivisers1() {
		int n = 36;
		for (int i = 1; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				System.out.print(i + " ");

				if (i != n / i)
					System.out.print(n / i + " ");
			}
		}
	}

	// *************************************************************************************
	/*
	 * Given a number, check whether it is prime or not. A prime number is a natural
	 * number that is only divisible by 1 and by itself means it has two factors
	 * Examples 2 3 5 7 11 13 17 19 …
	 */
	public static boolean checkPrime(int n) {

		if (n == 1 || n == 0)
			return false;

		if (n == 2)
			return true;

		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}

		return true;

	}

//	Optimised approach
	/*
	 * Using a for loop for checking if the number is divisible by a number from 2
	 * to its square root. Running the for loop from 2 to the square root of the
	 * number. And then checking if the number is divisible by the numbers from 2 to
	 * its square root.
	 */

	public static boolean checkPrime1(int n) {

		if (n == 1 || n == 0)
			return false;

		if (n == 2)
			return true;

		for (int i = 2; i * i < n; i++) {
			if (n % i == 0)
				return false;
		}

		return true;

	}

}
