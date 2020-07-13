package middle;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiangchen
 * @date 2020/07/10
 */
public class ThreeSum {
    /**
     * 方法一：暴力法(需要排序，超出时间限制)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<Integer> li = new ArrayList<>();
        for (int num : nums) {
            li.add(num);
        }
        Collections.sort(li);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && li.get(i).equals(li.get(i - 1))) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && li.get(j).equals(li.get(j - 1))) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (k > j + 1 && li.get(k).equals(li.get(k - 1))) {
                        continue;
                    }
                    if (li.get(i) + li.get(j) + li.get(k) == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(li.get(i));
                        list.add(li.get(j));
                        list.add(li.get(k));
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 方法二：暴力法(只对结果进行排序，也依然超时)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                    }
                }
            }
        }
        result.forEach(Collections::sort);
        Set<List<Integer>> set = new HashSet<>(result);
        return new ArrayList<>(set);
    }

    /**
     * 方法三：先排序，再加入hashmap减少一次遍历，然后就是各种边界条件
     */
    public static List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (map.containsKey(-nums[i] - nums[j])) {
                    if (nums[i] != -nums[i] - nums[j] && nums[j] != -nums[i] - nums[j]) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(-nums[i] - nums[j]);
                        result.add(list);
                    }
                    if (nums[i] != nums[j]) {
                        if (nums[i] == -nums[i] - nums[j] && map.get(nums[i]) > 1
                                || nums[j] == -nums[i] - nums[j] && map.get(nums[j]) > 1) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(-nums[i] - nums[j]);
                            result.add(list);
                        }
                    }
                }
            }
        }
        if (map.containsKey(0) && map.get(0) >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(0);
            list.add(0);
            result.add(list);
        }
        result.forEach(Collections::sort);
        return new ArrayList<>(new HashSet<>(result));
    }

    /**
     * 官方题解
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum4(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum1(arr));
        System.out.println(threeSum2(arr));
        System.out.println(threeSum3(arr));
        int[] arr2 = new int[]{-1, 0, 1, 0};
        System.out.println(threeSum1(arr2));
        System.out.println(threeSum2(arr2));
        System.out.println(threeSum3(arr2));
        int[] arr3 = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum1(arr3));
        System.out.println(threeSum2(arr3));
        System.out.println(threeSum3(arr3));
        int[] arr4 = new int[]{1, 1, -2};
        System.out.println(threeSum1(arr4));
        System.out.println(threeSum2(arr4));
        System.out.println(threeSum3(arr4));
    }
}
