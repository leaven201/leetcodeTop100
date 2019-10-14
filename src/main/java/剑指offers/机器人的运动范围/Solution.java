package 剑指offers.机器人的运动范围;

/**
 * @author LinZebin
 * @date 2019-10-08 14:41
 */
public class Solution {

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        return helper(threshold, rows, cols, 0, 0, visited);
    }

    /**
     * 从(row,col)出发在threshold的限制和visited的前提下，能够访问到几个未访问的点
     * @param threshold row、co限制条件
     * @param rows      总行数
     * @param cols      总列数
     * @param row       当前行
     * @param col       当前列
     * @param visited   是否访问过
     * @return
     */
    private int helper(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        int count = 0;
        // 出口
        // 越界 | 访问过 | 超过限制
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return count;
        }
        if (visited[row][col]) {
            return count;
        }
        if (getDigitSum(row) + getDigitSum(col) > threshold) {
            return count;
        }
        visited[row][col] = true;
        count = 1 +
            helper(threshold, rows, cols, row - 1, col, visited) + //上
            helper(threshold, rows, cols, row + 1, col, visited) + //下
            helper(threshold, rows, cols, row, col - 1, visited) + //左
            helper(threshold, rows, cols, row, col + 1, visited);   //右
        return count;
    }

    /**
     * 计算一个数字的各位数和
     * @param num 数字
     * @return
     */
    private int getDigitSum(int num) {
        if (num < 10) {
            return num;
        }
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        final int res = s.movingCount(18, 40, 40);
        System.out.println(res);
    }


}
