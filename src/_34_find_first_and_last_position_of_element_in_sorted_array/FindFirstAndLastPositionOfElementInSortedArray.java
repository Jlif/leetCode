package _34_find_first_and_last_position_of_element_in_sorted_array;

import java.util.Arrays;

/**
 * @author jiangchen
 * @date 2021/03/30
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;
        //先对左边界限进行二分法
        int start = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                start = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        result[0] = start;

        //再对右边界限进行二分法求解
        left = 0;
        right = nums.length - 1;
        int end = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                end = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        result[1] = end;

        return result;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray demo = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] arr = new int[]{1, 2, 3, 5, 5, 7, 7, 9};
        System.out.println(Arrays.toString(demo.searchRange(arr, 5)));
    }
}
