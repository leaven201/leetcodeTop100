package top100.medium.全排列_46;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LinZebin
 * @date 2019-10-14 19:08
 */
public class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return results;
        }
        boolean[] visited = new boolean[nums.length];
        helper(nums, visited, new ArrayList<>(), results);
        return results;
    }

    /**
     * 找出以current为前缀的所有组合，并加入到result里
     * @param nums     待全排列的数组
     * @param visited  是否访问过
     * @param current  当前前缀
     * @param results  结果集合
     */
    private static void helper(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> results){
        // 出口：当current.size() == nums.length时
        if (current.size() == nums.length){
            results.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]){
                current.add(nums[i]);
                visited[i] = true;
                helper(nums, visited, current, results);
                // 回溯
                visited[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        final List<List<Integer>> results = permute(nums);
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }

}
