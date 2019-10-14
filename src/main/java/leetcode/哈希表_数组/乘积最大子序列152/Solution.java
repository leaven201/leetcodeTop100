package leetcode.哈希表_数组.乘积最大子序列152;

/**
 * @author LinZebin
 * @date 2019-09-19 10:42
 */
class Solution {
    /**
     * 分析：只要不是遇到0，累积结果的绝对值一定是变大的
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        // 以当前nums[i]为子序列结尾时，所能获得的最小累积值（负数）
        int min = nums[0];
        // 以当前nums[i]为子序列结尾时，所能获得的最大累积值（正数）
        int max = nums[0];
        // 截止到i最大累积和
        int res = nums[0];
        // 用来当中间临时变量
        int maxEnd = 0;
        int minEnd = 0;
        for (int i = 1; i < nums.length; i++) {
            maxEnd = max * nums[i];
            minEnd = min * nums[i];
            // 更新min
            min = Math.min(Math.min(maxEnd, minEnd), nums[i]);
            // 更新max
            max = Math.max(Math.max(maxEnd, minEnd), nums[i]);
            // 更新res
            res = Math.max(res, max);
        }
        return res;
    }
}
