package algorithm.leetcode.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * <p>
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 示例 3：
 * <p>
 * 输入：nums = [1,0,1,2]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class LongestConsecutive {


    /**
     * 使用哈希表处理 ：时间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public int longestConsecutiveUsingHashV1(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentStreak = 1;
                int currentNum = num;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    /**
     * 哈希表处理，超出时间限制（时间复杂度O(n^2)）
     *
     * @param nums
     * @return
     */
    public int longestConsecutiveUsingHash(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;
        for (int num : numSet) {
            int currentLen = 1;
            if (numSet.contains(num + 1)) {
                int currentNum = num;
                while (numSet.contains(currentNum + 1)) {
                    currentNum = currentNum + 1;
                    currentLen++;
                }
            }
            longest = Math.max(longest, currentLen);
        }

        return longest;
    }

    /**
     * 排序后处理
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int longest = 1;
        int ret = 1;

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                longest++;
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                ret = Math.max(ret, longest);
                longest = 1;
            }
        }

        ret = Math.max(ret, longest);

        return ret;
    }

    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        System.out.println(longestConsecutive.longestConsecutiveUsingHashV1(new int[]{100, 1, 4, 200, 1, 3, 2}));
    }
}
