package com.codemistri.Step2;

public class Sorting_II {

	public static void main(String[] args) {
		int arr[] = { 4, 2, 1, 6, 7 };
		mergedSort(arr, 0, arr.length - 1);
	}

	/*
	 * Given an array of size n, sort the array using Merge Sort. Example 1: Input:
	 * N=5, arr[]={4,2,1,6,7} Output: 1,2,4,6,7,
	 */
	private static void mergedSort(int nums[], int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = (left + right) / 2;
		mergedSort(nums, left, mid);
		mergedSort(nums, mid + 1, right);
		merge(nums, left, mid, right);
	}

	private static void merge(int[] nums, int left, int mid, int right) {
		int[] result = new int[left + right+1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= right) {
			if (nums[i] < nums[j]) {
				result[k] = nums[i];
				i++;
			} else {
				result[k] = nums[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			result[k] = nums[i];
			i++;
			k++;
		}

		while (j <= right) {
			result[k] = nums[j];
			j++;
			k++;
		}

		for (int num : result) {
			System.out.print(num);
		}

	}

}
