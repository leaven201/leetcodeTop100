package 剑指offers.矩阵中的路径;

/**
 * @author LinZebin
 * @date 2019-10-03 16:51
 */
public class Solution {

    public boolean hasPath(char[][] matrix, String str) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // 记录是否访问过
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (helper(row, col, 0, matrix, visited, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断从（row，col）出发是否可以找到一条路径满足从index开始走完str
     *
     * @param row 当前位置row
     * @param col 当前位置column
     * @param index 从str的index开始往下找
     * @param matrix 字符矩阵
     * @param visited 记录该位置是否访问过
     * @param str 寻找路径的字符串
     */
    private boolean helper(int row, int col, int index, char[][] matrix, boolean[][] visited, String str) {
        // index已经到尾，返回true
        if (index >= str.length()) {
            return true;
        }
        // 越界返回false
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
            return false;
        }
        // 该点已经被访问过，返回false
        if (visited[row][col]) {
            return false;
        }
        // 该点字符与str的index字符不符，返回false
        if (matrix[row][col] != str.charAt(index)) {
            return false;
        }
        //将该点标记为访问过，继续向上下左右四个方向继续寻找
        visited[row][col] = true;
        boolean res =
            helper(row - 1, col, index + 1, matrix, visited, str) || // 上
                helper(row + 1, col, index + 1, matrix, visited, str) || // 下
                helper(row, col - 1, index + 1, matrix, visited, str) || // 左
                helper(row, col + 1, index + 1, matrix, visited, str); //右
        // 回溯，将该点标记为未访问
        visited[row][col] = false;
        return res;
    }

}
