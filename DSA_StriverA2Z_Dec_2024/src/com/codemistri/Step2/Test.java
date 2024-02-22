package com.codemistri.Step2;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 2, 3, 3, 4, 5 };
		int max = Integer.MIN_VALUE;
		int secondMax = max;

//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] > max) {
//
//				max = arr[i];
//			}
//
//		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > secondMax && arr[i] < max) {

				secondMax = arr[i];
			}
		}
		System.out.println(secondMax);

	}

}
