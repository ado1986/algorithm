package algorithm.leetcode.doublepointer;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * <p>
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * 解释：与 target 最接近的和是 0（0 + 0 + 0 = 0）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 *
 */

public class ThreeSumClosest {


    /**
     * 双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosestDoublePointer(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);

        int ans = Integer.MAX_VALUE;
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int second = first + 1, third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];

                if (sum == target) {
                    return sum;
                }

                // 分两步：1、判断是否是最优解
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }

                // 分两步：2、调整指针
                if (sum > target) {
                    int third0 = third - 1;
                    while (second < third0 && nums[third0] == nums[third])
                        --third0;
                    third = third0;
                } else if (sum < target) {
                    int second0 = second + 1;
                    while (second0 < third && nums[second0] == nums[second])
                        ++second0;
                    second = second0;
                }
            }
        }

        return ans;
    }


    /**
     * o(n^3)
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);

        int closest = Integer.MAX_VALUE;
        int ans = 0;
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int third = nums.length - 1;
                while (third > second) {
                    if (closest > Math.abs(nums[first] + nums[second] + nums[third] - target)) {
                        closest = Math.abs(nums[first] + nums[second] + nums[third] - target);
                        ans = nums[first] + nums[second] + nums[third];
                    }
                    third--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = {0, 1, 2};
        int target = 0;
        System.out.println(threeSumClosest.threeSumClosest(nums, target));
        System.out.println(threeSumClosest.threeSumClosestDoublePointer(nums, target));
    }
}
