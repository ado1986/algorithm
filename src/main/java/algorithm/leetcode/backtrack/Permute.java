package algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {

    public static void main(String[] args) {
        Permute permute = new Permute();
        System.out.println(permute.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> newNums = Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new));
        backtrack(combinations, new ArrayList<>(), newNums, len);
        return combinations;
    }

    private void backtrack(List<List<Integer>> combinations, List<Integer> combination, List<Integer> nums, int len) {
        if (combination.size() == len) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        for (Integer num : nums) {
            combination.add(num);
            List<Integer> newNums = new ArrayList<>(nums);
            newNums.remove(num);
            backtrack(combinations, combination, newNums, len);
            combination.remove(num);
        }

    }
}
