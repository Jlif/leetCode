package _28_implement_strstr;

/**
 * 实现strStr()函数。
 *
 * <p>给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
 *
 * <p>示例 1:
 * <p>输入: haystack = "hello", needle = "ll" 输出: 2
 *
 * <p>示例 2:
 * <p>输入: haystack = "aaaaa", needle = "bba" 输出: -1
 *
 * @author jiangchen
 * @date 2020/08/11
 */
public class ImplementStrstr {

    /**
     * 利用原生函数
     */
    public static int strStr1(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        if (!haystack.contains(needle)) {
            return -1;
        }
        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();
        for (int i = 0; i < haystack.length(); i++) {
            int idx = 0;
            while (idx < needle.length() && haystackArr[i + idx] == needleArr[idx]) {
                idx++;
            }
            if (idx == needle.length()) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 自己判断边界条件
     */
    public static int strStr2(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();
        for (int i = 0; i < haystack.length(); i++) {
            int idx = 0;
            while (idx < needle.length()
                    && i + idx < haystackArr.length
                    && haystackArr[i + idx] == needleArr[idx]) {
                idx++;
            }
            if (idx == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr2("mississippi", "issipi"));
    }
}
