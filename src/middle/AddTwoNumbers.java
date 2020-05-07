package middle;

import struct.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author JiangChen
 * @date 2019/02/16
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        boolean flag = false;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        while (tmp1 != null || tmp2 != null) {
            int a = tmp1 == null ? 0 : tmp1.val;
            int b = tmp2 == null ? 0 : tmp2.val;
            int tmpResult = flag ? a + b + 1 : a + b;
            if (tmpResult >= 10) {
                cur.next = new ListNode(tmpResult - 10);
                flag = true;
            } else {
                cur.next = new ListNode(tmpResult);
                flag = false;
            }
            tmp1 = tmp1 == null ? null : tmp1.next;
            tmp2 = tmp2 == null ? null : tmp2.next;
            cur = cur.next;
        }
        if (flag) {
            cur.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(7);
        l1.next.next.next = new ListNode(2);
        System.out.println(l1.toString());

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(l2.toString());
        System.out.println(addTwoNumbers(l1, l2).toString());
    }

}