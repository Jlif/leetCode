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
        String str = String.valueOf(val);
        ListNode tmp = next;
        while (tmp != null) {
            str = str + "->" + tmp.val;
            tmp = tmp.next;
        }
        return str;
    }
}
