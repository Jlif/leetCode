package easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author jiangchen
 * @date 2020/07/10
 */
public class LongestCommonPrefix {
    public static String calculate(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String template = strs[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < template.length(); i++) {
            char c = template.charAt(i);
            for (String str : strs) {
                if (i >= str.length() || c != str.charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"abc", "abd", "abe", "a"};
        System.out.println(calculate(strs));
    }
}
