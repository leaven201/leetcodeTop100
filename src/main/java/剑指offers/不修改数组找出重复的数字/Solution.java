package 剑指offers.不修改数组找出重复的数字;

/**
 * @author LinZebin
 * @date 2019-09-30 15:00
 */
public class Solution {
    /**
     * 方法1：
     * 与寻找循环链表的入口一样
     * 因为数组的长度是n+1,且元素范围是1-n，可以知道一定是有重复的
     * 把他想象成一个链表，可知这个是一个有环的链表
     * 转换成寻找有环链表的入口
     */
    public int duplicateInArray(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        //都先走一次(非常重要)
        //作用：1.防止slow==fast；2.保持fast的速度是2倍的slow，一定不能slow=nums[0],fast=nums[nums[0]],因为这不是2倍关系
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    /**
     * 方法2：
     * 二分+统计
     * 1-n，如果都只出现1，则只有n个数，因为n+1个数所有必然有重复的数
     * 1-n 二分 mid，统计大于mid的数和小于mid的数的个数，统计的总数输入超出（mid-start+1,end-mid+1），说明存在重复
     */
    public static int duplicateInArray2(int[] nums) {
        int start = 1;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = ((end - start) >> 1) + start;
            System.out.println(start+" "+mid+" "+end);
            int count = countNumsLessThenMid(nums, start, mid);
            // 说明重复的数存在于mid+1到end
            if (count > mid - start + 1){
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        if (start == end){
            return start;
        }
        if (countNumsLessThenMid(nums, start, start) > 1){
            return start;
        }else {
            return end;
        }
    }

    /**
     * 计算nums中属于[start，mid]的总数
     */
    private static int countNumsLessThenMid(int[] nums, int start, int mid) {
        int count = 0;
        for (int num : nums) {
            if (num <= mid && num >= start) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        final int res = duplicateInArray2(nums);
        System.out.println(res);
    }
}
