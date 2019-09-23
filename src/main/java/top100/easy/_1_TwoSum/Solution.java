package top100.easy._1_TwoSum;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 一定要先判断再加入map
            // 否则当加入的元素是target的一半的时候就会直接return
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    @Test
    public void test() {
        int[] nums = {3, 2, 4};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.twoSum(nums, 6)));
    }
}
