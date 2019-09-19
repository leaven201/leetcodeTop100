package top100.easy.求众数169;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author LinZebin
 * @date 2019-09-19 20:25
 */
public class Solution {

    /**
     * 方法一：排序，因为出现次数大于n/2，所以中间那个数就是出现最多的数
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 方法二：hashmap
     */
    public int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int times = map.get(num) + 1;
                if (times > nums.length / 2) {
                    return num;
                }
                map.put(num, times);
            } else {
                if (1 > nums.length / 2) {
                    return num;
                }
                map.put(num, 1);
            }
        }
        return -1;
    }

    /**
     * 方法3：最牛逼的O(n) 因为出现的次数大于一半，所以如果遇到是majority数就+1，不是就-1
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            //count等于0就更新candidate
            if (count == 0) {
                candidate = nums[i];
            }
            //相同就加1，不同就减1
            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
