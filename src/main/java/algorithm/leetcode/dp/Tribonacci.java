package algorithm.leetcode.dp;

/**
 * 1137. 第 N 个泰波那契
 * 泰波那契序列 Tn 定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 */
public class Tribonacci {

    public int tribonacci(int n) {
        int[] dp = new int[n + 1];
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];

        return dp[n];
    }
}
