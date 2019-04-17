package top100.medium._287_FindTheDuplicatNumber;

import org.junit.Test;

import java.awt.font.NumericShaper;

/**
 * @author LinZebin
 * @date 2019-04-15 20:40
 */
public class Solution {
    /**
     * 方法1
     * 与寻找循环链表的入口一样
     * 因为数组的长度是n+1,且元素范围是1-n，可以知道一定是有重复的
     * 把他想象成一个链表，可知这个是一个有环的链表
     * 转换成寻找有环链表的入口
     */
    public int findDuplicate(int[] nums) {
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

    //修改数组，因为是1-n范围的数在n+1大小的数组中，所以可以把他们按位置放到数组中，当找到index与value相等的时候，说明这个数已经被放过了即重复
    public int findDuplicate2(int[] nums) {
        int index = 0;
        int value = nums[0];
        while (index != value) {
            index = value;
            int temp = nums[value];
            nums[value] = value;
            value = temp;
        }
        return value;
    }



    @Test
    public void test() {
        int[] nums = {1, 3, 4, 2, 2};
        final int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
    }
}
