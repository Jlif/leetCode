package easy;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例  2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * @author jiangchen
 * @date 2020/06/30
 */
public class PanlindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int i = 0;
        while (i < x) {
            i = 10 * i + x % 10;
            x /= 10;
        }
        return x == i || x == i / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(110));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(0));
    }

}
