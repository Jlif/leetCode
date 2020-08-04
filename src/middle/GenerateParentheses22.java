package middle;

import java.util.*;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3 输出：[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 *
 * @author jiangchen
 * @date 2020/08/04
 */
public class GenerateParentheses22 {
    public static List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        if (n==0) {
            return res;
        }
//        dfs1("", n, n, res);
        dfs2("", 0, 0, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private static void dfs1(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left==0 && right==0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs1(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs1(curStr + ")", left, right - 1, res);
        }
    }

    private static void dfs2(String curStr, int left, int right, int n, List<String> res) {
        if (left==n && right==n) {
            res.add(curStr);
            return;
        }
        if (left < right) {
            return;
        }
        if (left < n) {
            dfs2(curStr + "(", left + 1, right, n, res);
        }
        if (right < n) {
            dfs2(curStr + ")", left, right + 1, n, res);
        }
    }

    /**
     * 广度优先遍历
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        if (n==0) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));

        while (!queue.isEmpty()) {

            Node curNode = queue.poll();
            if (curNode.left==0 && curNode.right==0) {
                res.add(curNode.res);
            }
            if (curNode.left > 0) {
                queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
            }
            if (curNode.right > 0 && curNode.left < curNode.right) {
                queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
            }
        }
        return res;
    }

    /**
     * 深度优先遍历
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis3(int n) {
        List<String> res = new ArrayList<>();
        if (n==0) {
            return res;
        }

        // 注意：只使用栈相关的接口，即只使用 `addLast()` 和 `removeLast()`
        Deque<Node> stack = new ArrayDeque<>();
        stack.addLast(new Node("", n, n));

        while (!stack.isEmpty()) {

            Node curNode = stack.removeLast();
            if (curNode.left==0 && curNode.right==0) {
                res.add(curNode.res);
            }
            if (curNode.left > 0) {
                stack.addLast(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
            }
            if (curNode.right > 0 && curNode.left < curNode.right) {
                stack.addLast(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
            }
        }
        return res;
    }

    static class Node {
        /**
         * 当前得到的字符串
         */
        private String res;
        /**
         * 剩余左括号数量
         */
        private int left;
        /**
         * 剩余右括号数量
         */
        private int right;

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis1(3));
    }
}
