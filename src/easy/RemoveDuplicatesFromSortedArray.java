package easy;

import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * <p>不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * <p>示例1:
 *
 * <p>给定数组 nums = [1,1,2],
 *
 * <p>函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * <p>你不需要考虑数组中超出新长度后面的元素。
 *
 * @author jiangchen
 * @date 2020/08/11
 */
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int p1 = 1;
        int p2 = 0;
        int tmp = nums[0];
        while (p2 < nums.length) {
            if (nums[p2] == tmp) {
                p2++;
                continue;
            }
            if (nums[p2] > tmp) {
                tmp = nums[p2];
                nums[p1] = tmp;
                p1++;
            }
            p2++;
        }
        return p1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
