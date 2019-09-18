package top100.medium.哈希表.和为K的子数组560;

import java.util.HashMap;

/**
 * @author LinZebin
 * @date 2019-09-18 11:39
 */
public class Solution {
    /**
    preSum思想
	preSum[i]，累加到i的累加和
	判断是否存在以i为止的子数组和为k<==>是否在i前存在preSum[j]，使得preSum[i]-preSum[j]==k
	因此需要快速定位是否有preSum[j]==preSum[i]-k，快速定位==>想到hashMap
    */
    public int subarraySum(int[] nums, int k) {
        // key：累加和；value：出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int preSum = 0;
        //很重要!!！！
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            // 判断map中是否存在累加和等于preSum-k的键
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }
            // 先计算在更新map，因为如果先更新map在计算会存在如果k=0时，出错
            // 更新map
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
