package easy;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author jiangchen
 * @date 2020/06/28
 */
public class ReverseInteger {

    /**
     * 方法一：字符串反转
     */
    public static int reverse(int i) {
        boolean flag = false;
        if (i < 0) {
            flag = true;
            i = -i;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i));
        sb.reverse();
        String s = sb.toString();
        while (s.startsWith("0")) {
            s = s.substring(1);
        }
        try {
            int x = Integer.parseInt(s);
            return flag ? -x : x;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 方法二：取余
     */
    public static int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(-123 / 10);
        System.out.println(-123 % 10);
    }
}
