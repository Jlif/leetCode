package _31_next_permutation;

import java.util.Arrays;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * <p>如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * <p>必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3] 输出：[1,3,2]
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,1] 输出：[1,2,3]
 * <p>
 * 示例 3：
 * 输入：nums = [1,1,5] 输出：[1,5,1]
 * <p>
 * 示例 4：
 * 输入：nums = [1] 输出：[1]
 *
 * @author jiangchen
 * @date 2020/11/26
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //找到第一个不再递增的位置
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        //如果到了最左边，就直接倒置输出
        if (i < 0) {
            reverse(nums, 0);
            return;
        }
        //找到刚好大于 nums[i]的位置
        int j = nums.length - 1;
        while (j >= 0 && nums[j] <= nums[i]) {
            j--;
        }
        //交换
        swap(nums, i, j);
        //利用倒置进行排序
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        NextPermutation demo = new NextPermutation();
        int[] source = new int[]{1, 5, 8, 4, 7, 6, 5, 3, 1};
        System.out.println(Arrays.toString(source));
        demo.nextPermutation(source);
        System.out.println(Arrays.toString(source));
    }

}
