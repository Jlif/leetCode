package hard;

import struct.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并  k  个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入: [ 1->4->5, 1->3->4, 2->6 ] 输出: 1->1->2->3->4->4->5->6
 *
 * @author jiangchen
 * @date 2020/08/04
 */
public class MergeKSortedLists23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        for (ListNode node : lists) {
            if (node!=null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            if (curr.next!=null) {
                queue.add(curr.next);
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.initWithParams(1, 4, 5);
        ListNode l2 = ListNode.initWithParams(1, 3, 4);
        ListNode l3 = ListNode.initWithParams(2, 6);
        ListNode[] lists = new ListNode[]{l1, l2, l3};
        System.out.println(mergeKLists(lists));
    }
}
