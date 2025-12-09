package algorithm.leetcode.doublepointer;

import java.util.*;

public class ThreeSum {

    /**
     * 不使用SET去重
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumDoublePointerV2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                int third = nums.length - 1;

                while (third > second && nums[third] + nums[second] + nums[first] > 0) {
                    third--;
                }

                if (second == third) {
                    break;
                }

                if (nums[third] + nums[second] + nums[first] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }

        return ans;
    }

    /**
     * 双指针 时间复杂度O(n^2)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumDoublePointer(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int o = 0 - nums[i];
                if (nums[left] + nums[right] == o) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    right--;
                } else if (nums[left] + nums[right] > o) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return new ArrayList<>(ans);
    }


    /**
     * 暴力枚举
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumOrigin(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        ans.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSumOrigin(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum.threeSumDoublePointer(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum.threeSumDoublePointerV2(new int[]{-1, 0, 1, 2, -1, -4}));
    }

}
