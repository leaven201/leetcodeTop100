package top100.medium._416_PartitionEqualSubsetSum;

import java.util.Arrays;

/**
 * 解题思路：动态规划（01背包问题)
 *
 * @author LinZebin
 * @date 2019-06-04 21:42
 */
public class Solution {

    /**
     * 解题思路：动态规划（01背包问题） dp[i]：表示该nums数组能否构成和为i 第一个循环：循环到i时,表示只使用前i个数能构成哪些和 第二个循环：更新使用前i个数，哪些和能够被构成
     */
    public boolean canPartition(int[] nums) {

        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 和为奇数
        if ((sum & 1) == 1) {
            return false;
        }
        Arrays.sort(nums);
        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            //循环一定要从target遍历到nums[i]，而不能反过来，
            //为什么呢？因为如果我们从nums[i]遍历到target的话，假如nums[i]=1的话，
            //那么[1, target]中所有的dp值都是true，因为dp[0]是true，
            //dp[1]会或上dp[0]，为true，dp[2]会或上dp[1]，为true，依此类推，完全使我们的dp数组失效了

            //为什么边界是target和nums[i]？
            //因为大于target则肯定不满足均分两数组，所以不用考虑
            //因为如果小于nums[i]；则dp[j-num[i]]会越界
            for (int j = target; j >= nums[i]; j--) {
                //为什么是这样？
                //判断nums[i]到target间的某个数是否是数组某些数的和
                //要嘛dp[j]之前已经得出可以构成，
                //要嘛dp[j - nums[i]]可以构成，此时再加上nums[i]就和为j了

                //怎么保证nums[i]不是构成dp[j-nums[i]]的一个元素（怎么保证每个元素只被选一次）
                //因为第一个循环中，每个nums[i]都只被遍历一次
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        Solution s = new Solution();
        final boolean b = s.canPartition(nums);
        System.out.println(b);
    }
}
