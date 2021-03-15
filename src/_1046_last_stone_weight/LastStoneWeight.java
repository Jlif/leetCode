package _1046_last_stone_weight;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果x == y，那么两块石头都会被完全粉碎；
 * 如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 * @author jiangchen
 * @date 2020/12/30
 */
public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(stones.length, (o1, o2) -> o2 - o1);
        for (int stone : stones) {
            queue.add(stone);
        }
        while (!queue.isEmpty() && queue.size() >= 2) {
            int x = queue.poll();
            int y = queue.poll();
            if (x > y) {
                queue.add(x - y);
            }
        }
        if (!queue.isEmpty()) {
            return queue.poll();
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(arr));
    }
}
