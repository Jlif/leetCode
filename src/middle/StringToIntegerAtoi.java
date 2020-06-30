package middle;

/**
 * @author jiangchen
 * @date 2020/06/29
 */
public class StringToIntegerAtoi {

    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx < n && chars[idx] == ' ') {
            // 去掉前导空格
            idx++;
        }
        if (idx == n) {
            //去掉前导空格以后到了末尾了
            return 0;
        }
        boolean negative = false;
        if (chars[idx] == '-') {
            //遇到负号
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            // 遇到正号
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            // 其他符号
            return 0;
        }
        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative ? -ans : ans;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi(" -012 3"));
        System.out.println(myAtoi(" 0w12 3"));
        System.out.println(myAtoi(" w012 3"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi(" -42"));
        System.out.println(myAtoi("3.14159"));
        System.out.println(myAtoi("+-2"));
        System.out.println(myAtoi("  -0012a42"));
        System.out.println(myAtoi("2147483646"));
    }
}
