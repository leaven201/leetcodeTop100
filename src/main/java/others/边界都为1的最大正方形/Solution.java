package others.边界都为1的最大正方形;

import org.junit.Test;

import java.util.Map;

/**
 * @author LinZebin
 * @date 2019-04-14 21:15
 */
public class Solution {

    public int maxSquare(int[][] matrix) {
        // 记录从[x,y]向右几个连续的1
        int[][] right = new int[matrix.length][matrix[0].length];
        // 初始化最右一列
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][matrix[0].length - 1] == 1) {
                right[row][matrix[0].length - 1] = 1;
            } else {
                right[row][matrix[0].length - 1] = 0;
            }
        }
        // 从最右一列向左构建right
        for (int column = matrix[0].length - 2; column >= 0; column--) {
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][column] == 1) {
                    right[row][column] = right[row][column + 1] + 1;
                } else {
                    right[row][column] = 0;
                }
            }
        }
        // 记录从[x,y]向下有几个连续的1
        int[][] down = new int[matrix.length][matrix[0].length];
        // 初始化最后一行
        for (int column = 0; column < matrix[0].length; column++) {
            down[matrix.length - 1][column] = matrix[matrix.length - 1][column] == 0 ? 0 : 1;
        }
        // 从最后一行向上构建down
        for (int row = matrix.length - 2; row >= 0; row--) {
            for (int column = 0; column < matrix[0].length; column++) {
                down[row][column] = matrix[row][column] == 0 ? 0 : down[row + 1][column] + 1;
            }
        }
        int max = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] == 1) {
                    int min1 = Math.min(right[row][column], down[row][column]);
                    int min2 = Math.min(down[row][column + min1 - 1], right[row + min1 - 1][column]);
                    int min = Math.min(min1, min2);
                    max = min > max ? min : max;
                }
            }
        }
        return max;
    }

    @Test
    public void test() {
        int[][] matrix = {{1, 1, 1, 0, 0},
                          {1, 0, 1, 1, 1},
                          {1, 1, 1, 1, 1},
                          {1, 0, 0, 1, 0}};
        int res = maxSquare(matrix);
        System.out.println(res);
    }

}
