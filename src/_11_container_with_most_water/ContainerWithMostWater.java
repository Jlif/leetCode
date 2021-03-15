package _11_container_with_most_water;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点  (i,  ai) 。在坐标内画 n 条垂直线，垂直线 i  的两个端点分别为  (i,  ai) 和 (i, 0)。找出其中的两条线，使得它们与  x  轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且  n  的值至少为 2。
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为  49。
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * @author jiangchen
 * @date 2020/07/09
 */
public class ContainerWithMostWater {

    /**
     * 方法1：暴力法
     *
     * @param height
     * @return
     */
    public static int maxArea1(int[] height) {
        int length = height.length;
        int capacity = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int tall = Math.min(height[i], height[j]);
                capacity = Math.max(capacity, (j - i) * tall);
            }
        }
        return capacity;
    }

    /**
     * 方法2：双指针
     *
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int length = height.length;
        int capacity = 0;
        int i = 0;
        int j = length - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                capacity = Math.max(capacity, height[i] * (j - i));
                i++;
            } else {
                capacity = Math.max(capacity, height[j] * (j - i));
                j--;
            }
        }
        return capacity;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea1(arr));
        System.out.println(maxArea2(arr));
    }
}
