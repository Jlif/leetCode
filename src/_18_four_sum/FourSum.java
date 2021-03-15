package _18_four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含  n 个整数的数组  nums  和一个目标值  target，判断  nums  中是否存在四个元素 a，b，c  和 d  ，使得  a + b + c + d  的值与  target  相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 * @author jiangchen
 * @date 2020/07/16
 */
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < n; first++) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < n; second++) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 对应的指针初始指向数组的最右端
                int fourth = n - 1;
                int tar = target - nums[first] - nums[second];
                for (int third = second + 1; third < n; third++) {
                    // 需要和上一次枚举的数不相同
                    if (third > second + 1 && nums[third] == nums[third - 1]) {
                        continue;
                    }
                    // 需要保证 c 的指针在 d 的指针的左侧
                    while (third < fourth && nums[third] + nums[fourth] > tar) {
                        --fourth;
                    }
                    // 如果指针重合，随着 c 后续的增加
                    // 就不会有满足 a+b+c+d=0 并且 c<d 的 d 了，可以退出循环
                    if (third == fourth) {
                        break;
                    }
                    if (nums[third] + nums[fourth] == tar) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        list.add(nums[fourth]);
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(arr, target));
    }
}
