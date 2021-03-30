package _33_search_in_rotated_sorted_array;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1],
 * nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回-1。
 *
 * @author jiangchen
 * @date 2021/03/30
 */
public class SearchInRotatedSortedArray {

    //暴力法，超出时间限制
    public int search1(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        if (target < nums[0] && target > nums[j]) {
            return -1;
        }
        if (j == 0) {
            return nums[0] == target ? 0 : -1;
        }
        while (i < j) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[j] == target) {
                return j;
            }
            if (nums[i] <= nums[i + 1]) {
                i++;
            }
            if (nums[j] > nums[j - 1]) {
                j--;
            }
        }
        return -1;
    }

    /**
     * 二分法
     */
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] <= nums[right]) {
                //说明右边有序
                //注意等号，边界
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                //说明左边有序
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray demo = new SearchInRotatedSortedArray();
        int[] arr = new int[]{1, 3};
        System.out.println(demo.search1(arr, 3));
        System.out.println(demo.search2(arr, 3));
    }
}
