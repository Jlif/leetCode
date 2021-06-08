package _39_combinationn_sun;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author jiangchen
 * @date 2021/06/08
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int length = candidates.length;
        if (length == 0) {
            return new ArrayList<>();
        }
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, length, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }


    }

    public static void main(String[] args) {
        CombinationSum demo = new CombinationSum();
        System.out.println(demo.combinationSum(new int[]{2, 7, 6, 3}, 7));
    }

}
