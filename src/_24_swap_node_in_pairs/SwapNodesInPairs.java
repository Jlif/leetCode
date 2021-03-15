package _24_swap_node_in_pairs;

import struct.ListNode;

/**
 * @author jiangchen
 * @date 2020/08/04
 */
public class SwapNodesInPairs {
    /**
     * 递归解法
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs1(next.next);
        next.next = head;
        return next;
    }

    /**
     * 非递归解法
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs2(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode tmp = dummyHead;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode start = tmp.next;
            ListNode end = tmp.next.next;
            tmp.next = end;
            start.next = end.next;
            end.next = start;
            tmp = start;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        System.out.println(swapPairs1(ListNode.initWithParams(1, 2, 3, 4, 5)));
        System.out.println(swapPairs2(ListNode.initWithParams(1, 2, 3, 4, 5)));
    }
}
