package _29_divide_two_integers;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * <p>返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * <p>整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * @author jiangchen
 * @date 2020/08/12
 */
public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        boolean flag = (dividend > 0) ^ (divisor > 0);

        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        int result = 0;
        while (dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while (dividend <= (temp_divisor << 1)) {
                if (temp_divisor <= (Integer.MIN_VALUE >> 1)) {
                    break;
                }
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if (!flag) {
            if (result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = -result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(divide(-100, 3));
        System.out.println(divide(1, 1));
        System.out.println(divide(-2147483648, -1));
        System.out.println(divide(2147483647, 1));
        System.out.println(divide(2147483647, 3));
    }
}
