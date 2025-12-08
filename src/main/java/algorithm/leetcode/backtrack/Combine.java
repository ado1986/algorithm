package algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(combinations, new ArrayList<>(), 1, n, k);
        return combinations;
    }

    private void backtrack(List<List<Integer>> combinations, List<Integer> combination, int nIndex, int n, int k) {
        if (combination.size() == k) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int i = nIndex; i <= n; i++) {
            combination.add(i);
            backtrack(combinations, combination, i + 1, n, k);
            combination.remove(Integer.valueOf(i));
        }
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        List<List<Integer>> combinations = combine.combine(4, 2);
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
