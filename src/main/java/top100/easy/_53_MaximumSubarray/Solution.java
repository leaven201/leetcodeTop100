package top100.easy._53_MaximumSubarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 计算前i个的和 prefixsum
        int[] prefixsum = new int[nums.length];
        prefixsum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixsum[i] = prefixsum[i - 1] + nums[i];
        }
        // 计算以第i个结尾的最大子数组，即用prefiexsum[i]-prefixsum[k]min,prefixsum[k]min是前i个prefixsum中最小的那个
        int prefixmin = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, prefixsum[i] - prefixmin);
            if (prefixsum[i] < prefixmin) {
                prefixmin = prefixsum[i];
            }
        }
        return max;
    }
}
