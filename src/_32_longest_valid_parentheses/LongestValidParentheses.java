package _32_longest_valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * @author jiangchen
 * @date 2021/03/29
 */
public class LongestValidParentheses {

    /**
     * 动态规划
     */
    public int longestValidParentheses1(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                //右括号前边是左括号
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    //右括号前边是右括号，并且除去前边的合法序列的前边是左括号
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public int longestValidParentheses2(String s) {
        int maxCount = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxCount = Math.max(maxCount, i - stack.peek());
                }
            }
        }
        return maxCount;
    }


    public static void main(String[] args) {
        LongestValidParentheses demo = new LongestValidParentheses();
        String testCase = "()(()";
        System.out.println(demo.longestValidParentheses1(testCase));
        System.out.println(demo.longestValidParentheses2(testCase));
    }
}
