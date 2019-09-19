package top100.easy.只出现一次的数字136;

/**
 * @author LinZebin
 * @date 2019-09-19 20:21
 */
public class Solution {

    /**
     * 异或 00-0 11-1 01-1 10-1 --> 出现两次的数异或后为0
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums){
            res = num ^ res;
        }
        return res;
    }
}
