package group_problem.sliding_window;

import java.util.Arrays;

/**
 * 小写字符 的 数值 是它在字母表中的位置（从 1 开始），因此 a 的数值为 1 ，b 的数值为 2 ，c 的数值为 3 ，以此类推。
 *
 * <p>字符串由若干小写字符组成，字符串的数值 为各字符的数值之和。例如，字符串 "abe" 的数值等于 1 + 2 + 5 = 8 。
 *
 * <p>给你两个整数 n 和 k 。返回 长度 等于 n 且 数值 等于 k 的 字典序最小 的字符串。
 *
 * @author jiangchen
 * @date 2020/12/14
 */
public class Smallest_string_with_a_given_number {

    public static int[] getSmallestString(int n, int k) {
        int[] result = new int[n];
        int i = 0;
        while ((n - i - 1) * 26 < k - (i - 1) * 26) {
            result[i] = 1;
            i++;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSmallestString(3, 27)));
    }
}
