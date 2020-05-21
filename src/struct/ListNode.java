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
