package middle;

/**
 * @author jiangchen
 * @date 2020/07/09
 */
public class IntegerToRoman {
    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < VALUES.length && num >= 0; i++) {
            while (VALUES[i] <= num) {
                num -= VALUES[i];
                sb.append(SYMBOLS[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(10));
    }
}
