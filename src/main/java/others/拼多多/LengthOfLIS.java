package others.拼多多;

import java.util.Scanner;

/**
 * @author LinZebin
 * @date 2019-08-10 19:18
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        //f[i]表示从前面某个位置（也可能i他自己）跳啊跳啊跳，跳到了i这个位置，总共得到的“龙”有多长
        //state
        int[] f = new int[nums.length];

        //initialize
        for(int i=0; i<nums.length; i++){
            f[i] = 1;
        }

        //function
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        //answer
        int max = 0;
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, f[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }

        int[] f = new int[nums.length];

        //initialize
        for(int i=0; i<nums.length; i++){
            f[i] = 1;
        }

        //function
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        //answer
        int max = 0;
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, f[i]);
        }

        System.out.println(max);

    }

}
