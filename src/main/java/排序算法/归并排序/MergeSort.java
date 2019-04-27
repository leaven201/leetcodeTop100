package 排序算法.归并排序;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author LinZebin
 * @date 2019-04-26 21:26
 */
public class MergeSort {

    public void mergeSort(int[] nums) {
        sort(nums, 0, nums.length - 1);

    }

    //定义：将数组从left到right排序
    private void sort(int[] nums, int left, int right) {
        //递归出口,left==right,说明只有一个数已经排好序
        if (left == right) {
            return;
        }
        //拆分成相等的两段再排序(右移一位相当于除2向下取整)
        int mid = left + ((right - left) >> 1);
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        mergeSort(nums, left, mid, right);

    }

    //合并两个排好序的数组
    private void mergeSort(int[] nums, int left, int mid, int right) {
        // 复制两段需要合并的数组
        int[] arr1 = new int[mid - left + 1];
        int[] arr2 = new int[right - mid];
        int index = 0;
        for (int i = left; i <= mid; i++) {
            arr1[index++] = nums[i];
        }
        index = 0;
        for (int i = mid + 1; i <= right; i++) {
            arr2[index++] = nums[i];
        }
        int index1 = 0;
        int index2 = 0;
        // 合并，将数组nums中，left到right的位置替换成排序好的数
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] <= arr2[index2]) {
                nums[left] = arr1[index1];
                index1++;
            } else {
                nums[left] = arr2[index2];
                index2++;
            }
            left++;
        }
        while (index1 < arr1.length) {
            nums[left] = arr1[index1];
            index1++;
            left++;
        }
        while (index2 < arr2.length) {
            nums[left] = arr2[index2];
            index2++;
            left++;
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 3, 5, 7, 2, 4, 6, 8, 7};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
