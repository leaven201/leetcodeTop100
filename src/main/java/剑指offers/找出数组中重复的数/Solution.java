package 剑指offers.找出数组中重复的数;

/**
 * @author LinZebin
 * @date 2019-09-04 16:34
 */
public class Solution {

    public static int duplicateInArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] >= nums.length) {
                return -1;
            }
            // 将i位置上的数放到正确的位置上
            while (nums[i] != i) {
                // 如果nums[i] 对应的位置上已经为nums[i]，则说明找到了重复的
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                // 不一样则交换nums[i]和nums[nums[i]]
                else {
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,0,2,5,3};
        final int res = duplicateInArray(nums);
        System.out.println(res);
    }
}
