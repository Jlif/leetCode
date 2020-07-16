package middle;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * @author jiangchen
 * @date 2020/07/15
 */
public class LetterCombinationsOfPhoneNumber {

    private static final String[] letterMap = {
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    /**
     * 暴力法
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        char[] chars = digits.toCharArray();
        for (char c : chars) {
            String letter = letterMap[Character.digit(c, 10)];
            char[] arr = letter.toCharArray();
            ArrayList<String> tmp = new ArrayList<>();
            if (res.size() == 0) {
                for (char j : arr) {
                    res.add(String.valueOf(j));
                }
                continue;
            }
            for (char j : arr) {
                res.forEach(i -> tmp.add(i + j));
            }
            res = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
