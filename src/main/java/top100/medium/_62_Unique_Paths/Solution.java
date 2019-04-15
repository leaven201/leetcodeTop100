package top100.medium._62_Unique_Paths;

import org.junit.Test;

/**
 * @author LinZebin
 * @date 2019-04-15 20:50
 */
public class Solution {

    //方法1
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }
        //sum[i][j]表示由(i,j)到start有多少种uniquePath
        int[][] sum = new int[m][n];
        //最右一列都为1
        for (int row = 0; row < m; row++) {
            sum[row][n-1] = 1;
        }
        //最下一行都为1
        for (int column = 0; column < n; column++) {
            sum[m-1][column] = 1;
        }
        //动态规划sum[i][j] = sum[i+1][j] + sum[i][j+1]
        for (int row = m-2; row >= 0; row--) {
            for (int column = n-2; column >= 0; column--) {
                sum[row][column] = sum[row+1][column] + sum[row][column+1];
            }
        }
        return sum[0][0];
    }

    //方法2：向右走(Right):n-1步，向下走(Down):m-1步，
    //走法：共走Right+Down步，选Right步向右走 = C(Right)(Right+Down)--越界问题(求阶乘时特别容易超过Integer.MAX_VALUE)
    public int uniquePaths2(int m, int n) {
        if(m == 1 && n == 1){
            return 1;
        }
        int Right = n - 1;
        int Down = m - 1;
        int sum = Right + Down;
        int min = Math.min(Right,Down);
        int count1 = 1;
        int count2 = 1;
        while(min > 0){
            count1 *= sum--;
            count2 *= min--;
        }
        return count1 / count2;
    }


    @Test
    public void test() {
        int res = uniquePaths(3, 2);
        System.out.println(res);
    }
}
