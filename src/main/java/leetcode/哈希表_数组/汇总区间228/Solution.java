package leetcode.哈希表_数组.汇总区间228;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LinZebin
 * @date 2019-09-18 12:22
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        if(nums.length == 1){
            res.add(String.valueOf(nums[0]));
            return res;
        }
        int start = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i - 1] + 1 != nums[i]){
                res.add(helper(start, nums[i-1]));
                start = nums[i];
            }
        }
        res.add(helper(start, nums[nums.length - 1]));
        return res;

    }

    private String helper(int start, int end){
        StringBuilder sb = new StringBuilder();
        if(start != end){
            return sb.append(start).append("->").append(end).toString();
        }
        return sb.append(start).toString();
    }
}
