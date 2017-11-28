package algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * 
 * @author ado1986
 *
 */
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		int[] ret = new int[2];
		Map container = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			if (container.containsKey(target - nums[i])) {
				ret[1] = i;
				// 注意对象原生类型转换
				ret[0] = (int) container.get(target - nums[i]);
				return ret;
			}
			container.put(nums[i], i);
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 10, 2, 3, 4, -1, 9 };

		TwoSum ts = new TwoSum();
		int[] ret = ts.twoSum(array, 8);
		for (int i = 0; i < ret.length; i++) {
			System.out.print(ret[i] + " ");
		}
	}

}
