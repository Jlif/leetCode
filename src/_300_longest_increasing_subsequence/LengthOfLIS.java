package _300_longest_increasing_subsequence;

import java.util.Arrays;

/**
 * “动态规划设计：最长递增子序列”
 *
 * @author jiangchen
 * @date 2020/12/25
 */
public class LengthOfLIS {

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // dp 数组全都初始化为 1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(a));
    }
}
