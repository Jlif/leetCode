package _27_remove_element;

import java.util.Arrays;

/**
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *
 * <p>不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * <p>元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * <p>示例 1:
 *
 * <p>给定 nums = [3,2,2,3], val = 3,
 *
 * <p>函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * <p>你不需要考虑数组中超出新长度后面的元素。
 *
 * @author jiangchen
 * @date 2020/08/11
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int p1 = 0;
        int p2 = 0;
        while (p2 < nums.length) {
            if (nums[p2] == val) {
                p2++;
                continue;
            }
            nums[p1++] = nums[p2++];
        }
        return p1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
    }
}
