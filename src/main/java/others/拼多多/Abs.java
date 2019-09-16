package others.拼多多;


import java.util.Scanner;

/**
 * @author LinZebin
 * @date 2019-08-10 19:57
 */
public class Abs {
    public static void minAbs(int[] nums){

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        int min = Integer.MAX_VALUE;
        int location = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int abs = Math.abs(nums[i] - nums[i + 1]);
            if (abs < min){
                location = i;
                min = abs;
            }
        }
        int n1 = nums[location];
        int n2 = nums[location+1];
        System.out.println(n1 + " " + n2);
    }
}
