package com.codemistri.Step3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.codemistri.Step2.Sorting_1;

public class Arrays_medium {

	public static void main(String[] args) {
		int[] nums = { 2, 0, 2, 0, 0, 2, 1, 1, 0 };
		sortZeroOne(nums);

	}
	/*
	 * Check if a pair with given sum exists in Array ou are not allowed to use the
	 * same element twice. Example: If the target is equal to 6 and num[1] = 3, then
	 * nums[1] + nums[1] = target is not a solution. Example 1: Input Format: N = 5,
	 * arr[] = {2,6,5,8,11}, target = 14 Result: YES (for 1st variant) [1, 3] (for
	 * 2nd variant)
	 */

	private static void findTwoSum(int[] nums, int target) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {

			int temp = target - nums[i];
			if (set.contains(temp)) {
				System.out.println("yes");
				return;
			}
			set.add(nums[i]);

		}
		System.out.println("No");
	}

	/*
	 * Given an array, find the pairs of numbers, whose sum = 11 {0, 14, 0, 4, 7, 8,
	 * 3, 5, 7}?
	 */
	private static void findPairsWithGivenSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					System.out.println("(" + nums[i] + "," + nums[j] + ") ");
				}
			}
		}

	}

	private static void findPairsWithGivenSum1(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int tempTarget = target - nums[i];
			if (map.containsKey(tempTarget)) {
				System.out.println("(" + tempTarget + "," + nums[i] + ") ");

			}
			map.put(nums[i], i);

		}

	}

	private static void findPairsWithGivenSum2(int[] nums, int target) {
		Arrays.sort(nums);
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			if (nums[low] + nums[high] == target) {
				System.out.println("(" + nums[low] + "," + nums[high] + ") ");
			}
			if (nums[low] + nums[high] < target) {
				low++;
			} else {
				high--;
			}

		}

	}

	private static void findPairsWithGivenSum3(int[] arr, int sum) {
		Set<Integer> s = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			int temp = sum - arr[i];
			if (s.contains(temp)) {
				System.out.println("(" + temp + ", " + arr[i] + ")");
			}
			s.add(arr[i]);
		}

	}

	/*
	 * Find the Majority Element that occurs more than N/2 times Example 1: Input
	 * Format: N = 3, nums[] = {3,2,3} Result: 3
	 */
	private static void findMejorityElement(int[] nums) {
		int count = nums.length / 2;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		map.forEach((k, v) -> {
			if (v > count) {
				System.out.println(k);
			}
		});

	}

	// Moore’s Voting Algorithm:
	private static void findMejorityElementOptimised(int[] nums) {
		int count = 1;
		int element = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (element == nums[i]) {
				count++;
			} else if (count == 0) {
				element = nums[i];
				count++;
			} else {
				count--;
			}
		}
		System.out.println(element);
	}

	/*
	 * Sort an array of 0s, 1s and 2s Given an array consisting of only 0s, 1s, and
	 * 2s. Write a program to in-place sort the array without using inbuilt sort
	 * functions. ( Expected: Single pass-O(N) and constant space) Input: nums
	 * =[2,0,2,1,1,0] Output: [0,0,1,1,2,2]
	 */

	private static void sortZeroOne(int nums[]) {
		Sorting_1.printArr(nums);
		int zero = 0;
		int one = 0;
		int len = nums.length;

		for (int i = 0; i < len; i++) {
			if (nums[i] == 0) {
				zero++;
			} else if (nums[i] == 1) {
				one++;
			}
		}

		for (int i = 0; i < len; i++) {
			if (i < zero) {
				nums[i] = 0;
			} else if (i < zero + one) {
				nums[i] = 1;
			} else {
				nums[i] = 2;
			}
		}
		Sorting_1.printArr(nums);
	}

	/* This problem is a variation of the popular Dutch National flag algorithm. */
	private static void sortZeroOneOptimised(int nums[]) {}

}
