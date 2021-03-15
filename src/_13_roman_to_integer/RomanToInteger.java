package _13_roman_to_integer;

import java.util.HashMap;

/**
 * @author jiangchen
 * @date 2020/07/09
 */
public class RomanToInteger {

    private static final HashMap<Character, Integer> MAP = new HashMap<>();

    static {
        MAP.put('M', 1000);
        MAP.put('D', 500);
        MAP.put('C', 100);
        MAP.put('L', 50);
        MAP.put('X', 10);
        MAP.put('V', 5);
        MAP.put('I', 1);
    }

    public static int romanToInt(String s) {
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = MAP.get(s.charAt(i));
        }
        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            if (i < res.length - 1 && res[i] < res[i + 1]) {
                sum = sum - res[i];
                i++;
            }
            sum = sum + res[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("DCCLXII"));
    }
}
