package algorithm.leetcode.dp;

/**
 * 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class LongestPalindrome {


    public String longestPalindromeDP(String s) {
        int len = s.length();

        boolean[][] dp = new boolean[len][len];
        int start = 0, maxLen = 0;
        for (int col = 0; col < len; col++) {
            for (int row = col; row >= 0; row--) {
                if (col == row) { // 单个字符串一定是回文串
                    dp[row][col] = true;
                } else if (col - row == 1) { // 两个字符判断是否相等
                    dp[row][col] = s.charAt(row) == s.charAt(col);
                } else {
                    dp[row][col] = dp[row + 1][col - 1] && s.charAt(row) == s.charAt(col);
                }
                if (dp[row][col] && col - row + 1 > maxLen) {
                    maxLen = col - row + 1;
                    start = row;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    /**
     * 暴力破解
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        for (int subLen = len; subLen > 0; subLen--) {
            for (int j = 0; j <= len - subLen; j++) {
                String sub = s.substring(j, j + subLen);
                if (isPalindrome(sub)) {
                    return sub;
                }
            }
        }

        return "";
    }

    /**
     * 是否为回文串
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int len = s.length();
        int low = 0, high = len - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }

        return true;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
//        System.out.println(longestPalindrome.longestPalindrome("babad"));
//        System.out.println(longestPalindrome.longestPalindrome("abb"));
        System.out.println(longestPalindrome.longestPalindromeDP("babad"));
        System.out.println(longestPalindrome.longestPalindromeDP("abb"));
        System.out.println(longestPalindrome.longestPalindromeDP("bb"));
    }

}
