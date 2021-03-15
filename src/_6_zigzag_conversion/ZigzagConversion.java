package _6_zigzag_conversion;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行  Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING"  行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例  1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例  2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows =  4
 * 输出:  "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * @author jiangchen
 * @date 2020/06/28
 */
public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        if (numRows <= 0) {
            return null;
        }
        if (numRows == 1) {
            return s;
        }
        if (numRows == 2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i = i + 2) {
                sb.append(s.charAt(i));
            }
            for (int i = 1; i < s.length(); i = i + 2) {
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }
        StringBuilder sb = new StringBuilder();
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < s.length(); j = j + cycleLen) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < s.length()) {
                    sb.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3));
        System.out.println(convert("LEETCODEISHIRING", 4));
    }
}
