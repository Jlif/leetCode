package easy;

import struct.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 *
 * @author jiangchen
 * @date 2020/07/27
 */
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0);
        ListNode dummy = tmp;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tmp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                tmp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        //下列优化：合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        tmp.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.initWithParams(1, 2, 4);
        ListNode l2 = ListNode.initWithParams(1, 3, 4);
        System.out.println(mergeTwoLists(l1, l2));
    }
}
