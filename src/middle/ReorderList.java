package middle;

import struct.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * <p>你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * <p>示例 1:
 *
 * <p>给定链表 1->2->3->4, 重新排列为 1->4->2->3. 示例 2:
 *
 * <p>给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiangchen
 * @date 2020/10/20
 */
public class ReorderList {

    //方法一：直接调换顺序
    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    //法2：快慢指针找到中点，然后反转后半部分链表，然后合并
    public static void reorderList2(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        //快慢指针求中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //将后半部分链表反转
        reverse(slow.next);
        slow.next = null;
        ListNode cur = head;
        while (fast != null) {
            ListNode pre = cur;
            ListNode suf = fast;
            pre.next = suf;
            suf.next = cur.next;
            cur = cur.next;
            fast = fast.next;
        }
    }

    public static void reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
    }

    public static void main(String[] args) {
        ListNode list = ListNode.initWithParams(1, 2, 3, 4, 5, 6, 7);
        reorderList2(list);
        System.out.println(list);
    }
}
