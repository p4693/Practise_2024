package com.codemistri.Step2;

import java.util.Arrays;
import java.util.List;

public class Sorting_1 {

	public static void main(String[] args) {
		int nums[] = { 13, 46, 24, 52, 20, 9 };
		insertionSort(nums);
	}

	/*
	 * Given an array of N integers, write a program to implement the Selection
	 * sorting algorithm.
	 */

	private static void selectionSort(int[] nums) {
		printArr(nums);

		for (int i = 0; i < nums.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < nums.length; j++) {
				minIndex = (nums[minIndex] > nums[j]) ? j : minIndex;

			}
			int temp = nums[i];
			nums[i] = nums[minIndex];
			nums[minIndex] = temp;

		}

		printArr(nums);

	}

	/*
	 * Given an array of N integers, write a program to implement the Bubble Sorting
	 * algorithm. { 13, 46, 24, 52, 20, 9 };
	 */
	private static void bubbleSort(int[] nums) {
		System.out.println("bubbleSort");
		printArr(nums);
		boolean swapped;
		for (int i = 0; i < nums.length; i++) {
			swapped = false;
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}

		printArr(nums);

	}
	private static void insertionSort(int[] nums) {
		System.out.println("insertionSort");
		printArr(nums);
		
		
		printArr(nums);

	}

	public static void printArr(int[] nums) {
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
