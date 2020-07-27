package easy;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1: 输入: "()" 输出: true
 * 示例 2: 输入: "()[]{}" 输出: true
 * 示例 3: 输入: "(]" 输出: false
 * 示例 4: 输入: "([)]" 输出: false
 * 示例 5: 输入: "{[]}" 输出: true
 *
 * @author jiangchen
 * @date 2020/07/27
 */
public class ValidParentheses {

    private static final Map<Character, Character> MAP = new HashMap<>();

    static {
        MAP.put('(', ')');
        MAP.put('[', ']');
        MAP.put('{', '}');
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        Set<Character> keys = MAP.keySet();
        List<Character> values = new ArrayList(MAP.values());
        for (Character c : chars) {
            if (keys.contains(c)) {
                deque.push(c);
            }
            if (values.contains(c)) {
                if (deque.isEmpty() || !c.equals(MAP.get(deque.pop()))) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("]"));
    }
}
