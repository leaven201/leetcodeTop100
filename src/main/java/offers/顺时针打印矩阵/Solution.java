package offers.顺时针打印矩阵;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LinZebin
 * @date 2019-05-19 14:21
 */
class Solution {

    public int[] printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            int[] res = new int[0];
            return res;
        }
        int Row = matrix.length;
        int Col = matrix[0].length;
        int[] res = new int[Row * Col];
        int row1 = 0;
        int column1 = 0;
        int row2 = Row - 1;
        int column2 = Col - 1;
        int row = 0;
        int column = 0;
        int index = 0;
        while (row1 <= row2 && column1 <= column2) {
            // 特殊情况只有一行或者只有一列
            // 只有一行,因为都是先有从左向右打再有从右向左打，所以只有一行时肯定是从左向右打
            if (row1 == row2) {
                for (int i = column1; i <= column2; i++) {
                    res[index] = matrix[row1][i];
                    index++;
                }
            }
            // 只有一列，只能是从上往下打
            else if (column1 == column2) {
                for (int i = row1; i <= row2; i++) {
                    res[index] = matrix[i][column1];
                    index++;
                }
            } else {
                // 以左上角和右下角两个位置确定一个矩阵leftTop[row1,column1],rightDown[row2,column2]
                // 打印这个矩阵框
                // 从左到右打印一行(不包括最右)
                while (column < column2) {
                    res[index] = matrix[row][column];
                    column++;
                    index++;
                }
                // 从上到下打印一列（不包括最下）
                while (row < row2) {
                    res[index] = matrix[row][column];
                    row++;
                    index++;
                }
                // 从右到左打印一行（不包括最左）
                while (column > column1) {
                    res[index] = matrix[row][column];
                    column--;
                    index++;
                }
                // 从下到上打印一列（不包括最上）
                while (row > row1) {
                    res[index] = matrix[row][column];
                    row--;
                    index++;
                }
            }
            // 此时打完好一圈，应该将leftTop和rightDown缩小打下一圈
            row1++;
            column1++;
            row2--;
            column2--;
            row++;
            column++;
        }
        return res;
    }
}