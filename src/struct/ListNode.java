package struct;

/**
 * @author JiangChen
 * @date 2020/04/22
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode initWithParams(int... args) {
        if (args == null) {
            return null;
        }
        ListNode node = null;
        ListNode tmp = null;
        for (int x : args) {
            if (node == null) {
                tmp = new ListNode(x);
                node = tmp;
            } else {
                tmp.next = new ListNode(x);
                tmp = tmp.next;
            }
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode tmp = next;
        while (tmp != null) {
            sb.append("->").append(tmp.val);
            tmp = tmp.next;
        }
        return sb.toString();
    }
}
