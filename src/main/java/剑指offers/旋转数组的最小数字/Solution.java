package 剑指offers.旋转数组的最小数字;

/**
 * @author LinZebin
 * @date 2019-10-03 16:11
 */
public class Solution {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            // 相等时，无法判断mid属于哪个数组，因此只能遍历
            if (nums[mid] == nums[end]) {
                end--;
            }
            // 为什么要跟end比较不跟start比较，为了移动指针时的统一（特殊情况已排序，和正常情况时的统一）
            // 向前移动end 顺序/mid属于第二截数组
            else if (nums[mid] < nums[end]) {
                end = mid;
            }
            // 向后移动start
            else {
                start = mid;
            }
        }
        // 此时二分到只有start 和 end 两个元素，返回两者小的
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }
}
