package top100.medium._215_KthLargestElement;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author LinZebin
 * @date 2019-04-13 21:37
 */
public class Solution {

    //O(n)
    public int findKthLargest(int[] nums, int k) {

        //找第k大的数 == 第（nums.length + 1  - k）个数
        k = nums.length + 1 - k;
        return quickSelect(nums, 0, nums.length - 1, k);

    }

    //定义：找出数组中strat-end间第k大的数
    private int quickSelect(int[] nums, int start, int end, int k) {
        // 选数组中最左元素作为轴，把数组中比它大的放到它的左边，比它小的放到它的右边
        int pivot = nums[start];
        int left = start;
        int right = end;
        while (left < right) {
            // 从数组的右端开始，如果nums[right]>=pivot，right--；如果nums[right]<pivot，则将nums[left]和nums[right]交换,
            // 交换完后pivot就变到nums[right]的位置上
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            // 交换
            swap(nums, left, right);
            // 交换一次后，从数组的左边left开始，如果nums[left]<=pivot,left++;如果nums[left]>pivot,则将nums[left]和nums[right]交换,
            // 交换完后pivot变回到nums[left]的位置上
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            // 交换
            swap(nums, left, right);
        }
        // 结束上面循环后，left=right,指向pivot的位置
        // 根据现在pivot处于数组中的位置，前k个，不在前k个，第k个，判断下一步操作
        // 第k个(pivot前面有k-1个比它小的数)
        if (left - start == k - 1) {
            return nums[left];
        }
        // left不在前k个（left前面有多于k-1个比它小的数），则在start到end内找第k个数
        else if (left - start > k - 1) {
            return quickSelect(nums, start, left, k);
        }
        // left在前k个（left前面有不足k-1个比它小的数），则等价于在left+1到end找第k-（left-start+1）个数
        else {
            return quickSelect(nums,
                left + 1, end, k - (left - start
                    + 1));//如果不+1的话可能会造成死循环，一开始start=0；如果第一个数的正确位置就                                                                               是nums[0]，那么就成死循环了
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
