package 剑指offers.顺时针打印矩阵;

import utils.matrix.MatrixUtil;

import java.util.*;

/**
 * @author LinZebin
 * @date 2019-05-19 14:21
 */
class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR) {
            printOneCircle(tR, tC, dR, dC, matrix, result);
            tR++;
            tC++;
            dR--;
            dC--;
        }
        return result;
    }

    /**
     * 打印以(tR,tC)(dR,dR)为标记的一圈
     *
     * @param tR 左上角row
     * @param tC 左上角column
     * @param dR 右下角row
     * @param dC 右下角column
     * @param matrix 需要打印的矩阵
     * @param result 打印结果
     */
    private void printOneCircle(int tR, int tC, int dR, int dC, int[][] matrix, List<Integer> result) {

        // 特殊情况，只有一行或者一列
        // 只有一行（只能是从左向右打）
        if (tR == dR) {
            for (int col = tC; col <= dC; col++) {
                result.add(matrix[tR][col]);
            }
        }
        // 只有一列（只能是从上向下打）
        else if (tC == dC) {
            for (int row = tR; row <= dR; row++) {
                result.add(matrix[row][tC]);
            }
        } else {
            // 正常情况，打印一圈
            // 当前行
            int curRow = tR;
            // 当前列
            int curCol = tC;
            // 打印上行
            while (curCol < dC) {
                result.add(matrix[tR][curCol]);
                curCol++;
            }
            // 打印右列
            while (curRow < dR) {
                result.add(matrix[curRow][dC]);
                curRow++;
            }
            // 打印下行
            while (curCol > tC) {
                result.add(matrix[dR][curCol]);
                curCol--;
            }
            // 打印左列
            while (curRow > tR) {
                result.add(matrix[curRow][tC]);
                curRow--;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = MatrixUtil.initIntMatrix();
        Solution s = new Solution();
        final List<Integer> list = s.spiralOrder(matrix);
        System.out.println(list);
    }
}