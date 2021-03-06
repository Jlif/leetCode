package _136_single_number;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {
    //解法一：暴力两次循环
    //解法二：hash表记录元素出现次数
    //解法三：排序
    //解法四：充分利用题目信息，异或
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            ans = ans ^ i;
        }
        return ans;
    }
}
