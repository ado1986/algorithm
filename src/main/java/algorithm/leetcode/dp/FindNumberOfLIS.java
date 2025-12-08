package algorithm.leetcode.dp;

/**
 * 673. 最长递增子序列的个数
 * <p>
 * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
 * <p>
 * 注意 这个数列必须是 严格 递增的。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 2000
 * -106 <= nums[i] <= 106
 */
public class FindNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] maxLen = new int[len];
        maxLen[0] = 1;
        for (int i = 1; i < len; i++) {
            maxLen[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxLen[i] = Math.max(maxLen[j] + 1, maxLen[i]);
                }
            }
        }

        int[] cnt = new int[len];
        cnt[0] = 1;
        for (int i = 1; i < len; i++) {
            cnt[i] = 1;
            int total = 0;
            for (int j = 0; j < i; j++) {
                if (maxLen[i] == maxLen[j] + 1) {
                    if (nums[i] > nums[j])
                        total += cnt[j];
                }
            }
            cnt[i] = Math.max(cnt[i], total);
        }

        int max = 0, total = 0;
        for (int i = 0; i < len; i++) {
            if (maxLen[i] > max) {
                max = maxLen[i];
                total = cnt[i];
            } else if (maxLen[i] == max) {
                total += cnt[i];
            }
        }

        return total;
    }

    /**
     * 简化版
     *
     * @param nums
     * @return
     */
    public int findNumberOfLISV2(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        FindNumberOfLIS findNumberOfLIS = new FindNumberOfLIS();
//        int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        int[] nums = {2, 2, 2, 2, 2};
        int res = findNumberOfLIS.findNumberOfLIS(nums);
        System.out.println(res);
    }
}
