package algorithm.leetcode.stack;

import java.util.Stack;

/**
 * 394. 字符串解码
 * <p>
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 测试用例保证输出的长度不会超过 105。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * <p>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * <p>
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 30
 * s 由小写英文字母、数字和方括号 '[]' 组成
 * s 保证是一个 有效 的输入。
 * s 中所有整数的取值范围为 [1, 300]
 */
public class DecodeString {

    public String decodeString(String s) {
        StringBuffer sbf = new StringBuffer();
        Stack stack = new Stack<>();
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                sum = sum * 10 + (c - '0');
            } else if (c == '[') {
                stack.push(sum);
                sum = 0;
                stack.push(c);
            } else if (c == ']') {
                while (!stack.isEmpty()) {
                    Object o = stack.pop();
                    if (o instanceof Character) {
                        if (!o.equals(new Character('['))) {
                        }
                    } else if (o instanceof Integer) {

                    }
                }
            } else {
                stack.push(c);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int test = 28300;
        Byte b = (byte) test;
        System.out.println(Integer.SIZE);
    }
}
