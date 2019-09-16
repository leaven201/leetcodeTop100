package iqiyi.DI序列的有效排序leetcode903;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LinZebin
 * @date 2019-09-08 15:47
 */
public class Solution {



    public static double vector(int n, int m) {
        double[][] dp = new double[n + 1][m + 1];
        for (int row = 1; row <= n; row++) {
            dp[row][0] = 1;
            dp[row][1] = (row*1.0) / (row + 1);
        }
        for (int col = 1; col <= m; col++) {
            dp[1][col] = 1.0 / (col + 1);
        }
        for (int row = 2; row <= n; row++) {
            for (int col = 2; col <= m; col++) {
                int sum = row + col;
                double pickBlue = (col - 2)*1.0 / (sum - 2);
                pickBlue = pickBlue < 0 ? 0 : pickBlue;
                double pickRed = 1 - pickBlue;
                double hit = row*1.0 / sum;
                double unhit;
                if (col - 3 >= 0) {
                    unhit = (col*1.0 / sum) * ((col - 1)*1.0 / (sum - 1)) *
                        ((pickBlue * dp[row][col - 3]) + (pickRed * dp[row - 1][col - 2]));
                } else {
                    unhit = (col*1.0 / sum) * ((col - 1)*1.0 / (sum - 1)) *
                        (pickRed * dp[row - 1][col - 2]);
                }
                dp[row][col] = hit + unhit;
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        final double vector = vector(2, 2);
        System.out.println(vector);
    }
}
