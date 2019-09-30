package 华为;

import java.util.*;

/**
 * @author LinZebin
 * @date 2019-09-25 19:52
 */
public class Main1 {
    static int[] count;
    private static int[] func(int[] nums){
        int ability = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            final int count = count(nums, i);
            ability += count;
            max = Math.max(max, ability);
        }
        return new int[]{max, ability};
    }
    private static int count(int[] nums, int index){
        int count =0;
        for (int i=0 ; i<index; i++){
            if (nums[i] > nums[index]){
                count--;
            }else if (nums[i] < nums[index]){
                count++;
            }
        }
        return count;
    }

    public static List<Integer> countSmaller(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        ArrayList<Integer> res = new ArrayList<>();
        count = new int[nums.length];
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
        }
        mergesort(nums, indexes, 0, nums.length-1);
        for (int i = 0; i < count.length; i++) {
            res.add(count[i]);
        }
        return res;
    }

    private static void mergesort(int[] nums, int[] indexes, int start, int end) {
        if (end <= start){
            return;
        }
        int mid = (start + end)/2;
        mergesort(nums,indexes,start,mid);
        mergesort(nums,indexes,mid+1,end);
        merge(nums, indexes, start,end);
    }

    private static void merge(int[] nums, int[] indexes, int start, int end) {
        int mid = (start + end) / 2;
        int left_index = start;
        int right_index = mid+1;
        int rightcount = 0;
        int[] new_indexes = new int[end - start + 1];
        int sort_index = 0;
        while (left_index <= mid && right_index <= end){
            if (nums[indexes[right_index]] < nums[indexes[left_index]]){
                new_indexes[sort_index] = indexes[right_index];
                rightcount++;
                right_index++;
            }else {
                new_indexes[sort_index] = indexes[left_index];
                count[indexes[left_index]] += rightcount;
                left_index++;
            }
            sort_index++;
        }
        while (left_index <= mid){
            new_indexes[sort_index] = indexes[left_index];
            count[indexes[left_index]] += rightcount;
            left_index++;
            sort_index++;
        }
        while (right_index<=end){
            new_indexes[sort_index++] = indexes[right_index++];
        }
        for (int i = start; i<= end; i++){
            indexes[i] = new_indexes[i - start];
        }
    }



    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int[][] res = new int[n][2];
        for (int i = 0; i < n; i++) {
            int m = in.nextInt();
            int[] nums = new int[m];
            for (int j = 0; j < m; j++) {
                nums[j] = in.nextInt();
            }
            final int[] re = func(nums);
            res[i] = re;
        }
        for (int[] re : res) {
            System.out.println(re[0] + " " + re[1]);
        }
    }
}
