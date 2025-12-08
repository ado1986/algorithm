package algorithm.leetcode.dp;

/**
 * 714. 买卖股票的最佳时机含手续费
 */
public class maxProfit4Fee {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0]; // 第一天买入股票，卖出时再计算手续费
        dp[0][0] = 0; // 第一天不买入股票
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        maxProfit4Fee maxProfit4Fee = new maxProfit4Fee();
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit4Fee.maxProfit(prices, fee));
    }

}
