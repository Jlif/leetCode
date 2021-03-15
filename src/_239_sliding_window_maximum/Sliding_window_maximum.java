package _239_sliding_window_maximum;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * <p>返回滑动窗口中的最大值。
 *
 * @author jiangchen
 * @date 2020/12/14
 */
public class Sliding_window_maximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new ArrayDeque<>();
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        int maxIdx = 0;
        //初始化deq
        for (int i = 0; i < k; i++) {
            if (!deq.isEmpty() && deq.getFirst() == i - k) {
                deq.removeFirst();
            }
            while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
                deq.removeLast();
            }
            deq.addLast(i);
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        int[] result = new int[n - k + 1];
        result[0] = nums[maxIdx];
        for (int i = k; i < n; i++) {
            if (!deq.isEmpty() && deq.getFirst() == i - k) {
                deq.removeFirst();
            }
            while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
                deq.removeLast();
            }
            deq.addLast(i);
            result[i - k + 1] = nums[deq.getFirst()];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(a, 3)));
    }
}
