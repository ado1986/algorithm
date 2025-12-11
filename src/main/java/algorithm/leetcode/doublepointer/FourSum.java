package algorithm.leetcode.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums.length < 4) {
            return ans;
        }
        //排序
        Arrays.sort(nums);


        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1])
                continue;

            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1])
                    continue;

                int third = second + 1, fourth = nums.length - 1;
                while (third < fourth) {
                    // 避免溢出
                    long sum = (long) nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (sum == target) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        list.add(nums[fourth]);
                        ans.add(list);

                        int third0 = third + 1;
                        while (third0 < fourth && nums[third0] == nums[third])
                            ++third0;
                        third = third0;
                    }
                    if (sum > target) {
                        int fourth0 = fourth - 1;
                        while (third < fourth0 && nums[fourth0] == nums[fourth])
                            --fourth0;
                        fourth = fourth0;
                    }
                    if (sum < target) {
                        int third0 = third + 1;
                        while (third0 < fourth && nums[third0] == nums[third])
                            ++third0;
                        third = third0;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }

}
