package 排序算法.最大分数;

import java.util.Scanner;

/**
 * @author LinZebin
 * @date 2019-09-15 16:05
 */
public class Solution {


    public int maxScore(int[] values) {
        if (values.length == 0) {
            return 0;
        }

        int n = values.length;
        int[][] maxTotal = new int[n][n];
        boolean[][] calculated =new boolean[n][n];


        return calculate(0,values.length - 1, maxTotal, calculated, values);
    }

    int calculate(int left, int right, int [][]maxTotal, boolean [][]calculated, int []values) {

        if(calculated[left][right]) {
            return maxTotal[left][right];
        }

        calculated[left][right] = true;

        if (left == right) {
            maxTotal[left][right] = values[left];
        } else if(left + 1 == right) {
            maxTotal[left][right] = Math.max(values[left], values[right]);
        } else {

            int  firstPlayerPickLeft = values[left] +
                // why Math.min? cuz it's opponent's turn, whose goal is to make the first player lose
                Math.min(
                    // opponent picks left element of the remained list
                    calculate(left + 2, right, maxTotal, calculated, values),
                    // opponent picks right element of the remained list
                    calculate(left + 1, right - 1, maxTotal, calculated, values)
                );

            int  firstPlayerPickRight = values[right] +
                // why Math.min? cuz it's opponent's turn, whose goal is to make the first player lose
                Math.min(
                    // opponent picks left element of the remained list
                    calculate(left, right - 2, maxTotal, calculated, values),
                    // opponent picks right element of the remained list
                    calculate(left + 1, right - 1, maxTotal, calculated, values)
                );

            maxTotal[left][right] = Math.max(firstPlayerPickLeft, firstPlayerPickRight);
        }

        return maxTotal[left][right];
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }


    }
}
