package middle;

/**
 * 给你一个整数数组 nums  ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释:  子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释:  结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * @author jiangchen
 */
public class MaximumProductSubArray {
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE, curMin = 1, curMax = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = curMax;
                curMax = curMin;
                curMin = tmp;
            }
            curMax = Math.max(nums[i], nums[i] * curMax);
            curMin = Math.min(nums[i], nums[i] * curMin);
            max = Math.max(max, curMax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, -2, 6, 9, -1};
        System.out.println(maxProduct(arr));
    }
}
