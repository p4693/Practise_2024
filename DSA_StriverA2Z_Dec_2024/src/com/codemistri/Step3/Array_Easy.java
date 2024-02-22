package com.codemistri.Step3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.codemistri.Step2.Sorting_1;

public class Array_Easy {

	public static void main(String[] args) {
		int[] a = { 3, 2, 3, 2, 2, 2 };
		

		/*
		 * List<Integer> list = List.of(13, 46, 24, 52, 20, 9);
		 * System.out.println("Laregest element using java8"); Integer max =
		 * list.stream().reduce(Integer.MIN_VALUE, (x, y) -> x > y ? x : y);
		 * System.out.println(max);
		 */
	}

	/* Given an array, we have to find the largest element in the array. */
	private static void findMax(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			max = (max < nums[i]) ? nums[i] : max;
		}
		System.out.println(max);
	}

	/* Given an array, we have to find the second largest element in the array. */
	private static void findSecondMax(int[] nums) {
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			max = (max < nums[i]) ? nums[i] : max;

		}
		for (int i = 0; i < nums.length; i++) {
			secondMax = (max > nums[i] && secondMax < nums[i]) ? nums[i] : secondMax;

		}

		System.out.println(secondMax);
	}

	/*
	 * optimum approach int[] arr = {1, 2, 4, 7, 7, 5};
	 */
	private static void findSecondMaxOptimised(int[] arr) {
		int large = Integer.MIN_VALUE;
		int second_large = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > large) {
				second_large = large;
				large = arr[i];
			}

			else if (arr[i] > second_large && arr[i] != large) {
				second_large = arr[i];
			}
		}
		System.out.println(second_large);
	}

	/*
	 * Given an array of size n, write a program to check if the given array is
	 * sorted in (ascending / Increasing / Non-decreasing) order or not. If the
	 * array is sorted then return True, Else return False.
	 */

	private static void checkSorted(int[] nums) {
		boolean isSorted = true;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				isSorted = false;
				break;
			}
		}
		System.out.println("Sorting status" + isSorted);
	}

	/*
	 * Remove Duplicates in-place from Sorted Array.If there are k elements after
	 * removing the duplicates, then the first k elements of the array should hold
	 * the final result. It does not matter what you leave beyond the first k
	 * elements. Return k after placing the final result in the first k slots of the
	 * array. Input: arr[1,1,2,2,2,3,3] Output: arr[1,2,3,_,_,_,_] Explanation:
	 * Total number of unique elements are 3, i.e[1,2,3] and Therefore return 3
	 * after assigning [1,2,3] in the beginning of the array.
	 * arr[1,1,1,2,2,3,3,3,3,4,4]
	 */

	private static void removeDuplicatesBF(int[] nums) {

		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			hashSet.add(nums[i]);
		}
		System.out.println(hashSet);
		System.out.println();
		System.out.println(hashSet.size());
	}

	private static void removeDuplicatesOptimised(int[] nums) {
		Sorting_1.printArr(nums);
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}

		}
		Sorting_1.printArr(nums);
		System.out.println(i + 1);
	}

	/*
	 * Left Rotate the Array by One Example 1: Input: N = 5, array[] = {1,2,3,4,5}
	 * Output: 2,3,4,5,1 Explanation: Since all the elements in array will be
	 * shifted toward left by one so ‘2’ will now become the first index and and ‘1’
	 * which was present at first index will be shifted at last.
	 */
	private static void leftRotate(int[] nums) {
		Sorting_1.printArr(nums);
		int temp = nums[0];
		for (int i = 1; i < nums.length; i++) {
			nums[i - 1] = nums[i];
		}
		nums[nums.length - 1] = temp;
		Sorting_1.printArr(nums);

	}

	/*
	 * Given an array of integers, rotating array of elements by d elements either
	 * left or right.array[] = {1,2,3,4,5}
	 */
	private static void leftRotateByDSteps(int[] nums, int d) {
		Sorting_1.printArr(nums);
		int len = nums.length;
		int steps = d % len;// for keeping the range within the length of
		int[] temp = new int[steps];

		for (int i = 0; i < steps; i++) {
			temp[i] = nums[i];
		}

		for (int i = steps; i < len; i++) {
			nums[i - steps] = nums[i];
		}
		int k = 0;
		for (int i = len - steps; i < len; i++) {
			nums[i] = temp[k];
			k++;
		}
		Sorting_1.printArr(nums);

	}

	// Optimized
	/*
	 * 1 2 3 4 5 ,d=2 1st step reverse 1std nums and rest nums like 2 1 5 4 3
	 * reverse whole numbers 3 4 5 1 2
	 */
	private static void leftRotateByDStepsOptimised(int[] nums, int d) {
		Sorting_1.printArr(nums);
		reverseArr(nums, 0, d - 1);
		reverseArr(nums, d, nums.length - 1);
		reverseArr(nums, 0, nums.length - 1);
		Sorting_1.printArr(nums);

	}

	private static void reverseArr(int[] nums, int low, int high) {

		while (low <= high) {
			int temp = nums[low];
			nums[low] = nums[high];
			nums[high] = temp;
			low++;
			high--;
		}

	}

	/*
	 * Problem Statement: You are given an array of integers, your task is to move
	 * all the zeros in the array to the end of the array and move non-negative
	 * integers to the front by maintaining their order. Example 1: Input: 1 ,0 ,2
	 * ,3 ,0 ,4 ,0 ,1 Output: 1 ,2 ,3 ,4 ,1 ,0 ,0 ,0 Explanation: All the zeros are
	 * moved to the end and non-negative integers are moved to front by maintaining
	 * order
	 */
	private static void moveZerostoEnd(int[] nums) {
		Sorting_1.printArr(nums);
		int[] result = new int[nums.length];
		int k = 0;
		for (int i = 0; i < result.length; i++) {
			if (nums[i] != 0) {
				result[k] = nums[i];
				k++;
			}
		}
		for (int i = k; i < result.length; i++) {
			result[k] = 0;
		}
		Sorting_1.printArr(result);
	}

	private static void moveZerostoEndOptimised(int[] nums) {
		Sorting_1.printArr(nums);
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				j = i;
				break;
			}
		}

		for (int i = j + 1; i < nums.length; i++) {
			if (nums[i] != 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				j++;
			}
		}
		Sorting_1.printArr(nums);
	}

	/*
	 * Given two sorted arrays, arr1, and arr2 of size n and m. Find the union of
	 * two sorted arrays. The union of two arrays can be defined as the common and
	 * distinct elements in the two arrays.NOTE: Elements in the union should be in
	 * ascending order.
	 */

	/*
	 * Example 1: Input: n = 5,m = 5. arr1[] = {1,2,3,4,5} arr2[] = {2,3,4,4,5}
	 * Output: {1,2,3,4,5}
	 */
	private static void findUnion(int[] nums1, int[] nums2) {
		TreeMap<Integer, Integer> map = new TreeMap<>();// We can use treeSet Also at the same place

		for (int i = 0; i < nums1.length; i++) {
			map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);

		}

		for (int i = 0; i < nums2.length; i++) {
			map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);

		}
		int[] result = new int[map.size()];
		int i = 0;
		map.forEach((k, v) -> {
			System.out.print(k + " ");
		});

		// Sorting_1.printArr(result);
	}

	//
	private static void findUnionOptimised(int[] nums1, int[] nums2) {

	}

	/*
	 * Given an integer N and an array of size N-1 containing N-1 numbers between 1
	 * to N. Find the number(between 1 to N), that is not present in the given
	 * array. Example 1: Input Format: N = 5, int array[] = {1,2,4,5} Result: 3
	 * Explanation: In the given array, number 3 is missing. So, 3 is the answer.
	 */

	private static void findMissingNumber(int[] nums, int N) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		for (int i = 1; i <= N; i++) {
			if (!map.containsKey(i)) {
				System.out.println(i);
				break;
			}

		}
	}

	private static void findMissingNumberOptimal1(int[] nums, int N) {
		int sum = N * (N + 1) / 2;
		int tempSum = 0;
		for (int i = 0; i < nums.length; i++) {
			tempSum += nums[i];
		}
		System.out.println(sum - tempSum);
	}

	/*
	 * XOR of two same numbers is always 0 i.e. a ^ a = 0. Property 1. XOR of a
	 * number with 0 will result in the number itself 0 ^ a = a.
	 */
	private static void findMissingNumberOptimal2(int[] nums, int N) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result ^= nums[i] ^ N;
			N--;
		}
		System.out.println(N ^ result);
	}

	/*
	 * Given an array that contains only 1 and 0 return the count of maximum
	 * consecutive ones in the array.Example 1: Input: prices = {1, 1, 0, 1, 1, 1}
	 * Output: 3
	 */
	private static void maxCosecutiveOnes(int[] nums) {
		int max = 0;
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				temp++;
			} else {
				temp = 0;
			}
			max = Math.max(max, temp);
		}
		System.out.println(max);
	}

	/*
	 * Longest Subarray with sum K | [Postives and Negatives]Example 1: Input
	 * Format: N = 3, k = 5, array[] = {2,3,5} Result: 2 Explanation: The longest
	 * subarray with sum 5 is {2, 3}. And its length is 2.
	 * 
	 * Example 2: Input Format: N = 3, k = 1, array[] = {-1, 1, 1} Result: 3
	 * Explanation: The longest subarray with sum 1 is {-1, 1, 1}. And its length is
	 * 3.
	 */

	private static void findLongestSubArrayBruteForce(int[] arr, int target) {

		int longest = 0;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = 1; j < arr.length; j++) {
				for (int k = i; k <= j; k++) {
					sum = sum + arr[k];
					if (sum == target) {
						longest = Math.max(longest, j - i + 1);
					}
				}
			}

		}
		System.out.println(longest);

	}

	private static void findLongestSubArrayOptimised1(int[] arr, int target) {

		int longest = 0;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum == target) {
					longest = Math.max(longest, j - i + 1);
				}
			}

		}
		System.out.println(longest);

	}

	/*
	 * Given a non-empty array of integers arr, every element appears twice except
	 * for one. Find that single one. Example 1: Input Format: arr[] = {2,2,1}
	 * Result: 1 Explanation: In this array, only the element 1 appear once and so
	 * it is the answer.
	 */

	private static void findNoThatAppearsonce(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result ^= nums[i];
		}
		System.out.println(result);

	}

	
}
