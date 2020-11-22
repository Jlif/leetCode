package hard;

import struct.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * @author JiangChen
 * @date 2020/05/16
 */
public class ReverseNodesInKGroup {

    //方法一：使用一个双向队列去存放
    public static ListNode reverseKGroup(ListNode head, int k) {
        Deque<Integer> stack = new ArrayDeque<>(k);
        ListNode dummy = null;
        ListNode h = dummy;
        ListNode tmp = head;
        while (tmp != null) {
            for (int i = 0; i < k; i++) {
                stack.push(tmp.val);
                tmp = tmp.next;
                if (tmp == null && stack.size() < k) {
                    while (!stack.isEmpty()) {
                        h.next = new ListNode(stack.pollLast());
                        h = h.next;
                    }
                    break;
                }
            }
            if (dummy == null) {
                dummy = new ListNode(stack.pop());
                h = dummy;
            }
            while (!stack.isEmpty()) {
                h.next = new ListNode(stack.pop());
                h = h.next;
            }
        }
        return dummy;
    }

    //方法二：直接翻转链表
    public static ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;

            pre = start;
            end = start;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        l1.next.next.next.next.next.next = new ListNode(7);
        System.out.println(reverseKGroup2(l1, 2));
    }

}
