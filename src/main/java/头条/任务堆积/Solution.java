package 头条.任务堆积;


import java.util.Arrays;

/**
 * @author LinZebin
 * @date 2019-09-15 16:50
 */
public class Solution {

    public static int[] taskQueue(int[][] tasks) {
        int[] res = new int[2];
        if (tasks == null || tasks.length == 0 || tasks[0].length == 0) {
            return res;
        }
        if (tasks.length == 1) {
            res[0] = tasks[0][0] + 1;
            res[1] = tasks[0][0];
            return res;
        }
        // 当前阻塞任务数
        int blockTask = tasks[0][1];
        // 最多阻塞任务数
        int max = blockTask;
        for (int i = 1; i < tasks.length; i++) {
            // 计算两个任务时间间隔
            int useTime = tasks[i][0] - tasks[i - 1][0];
            // 更新当前阻塞任务数（经过useTime会完成响应数目的文件）
            blockTask = blockTask - useTime;
            if (blockTask < 0) {
                blockTask = 0;
            }
            // 更新当前阻塞任务数（增加相应的文件）
            blockTask += tasks[i][1];
            // 更新最多阻塞任务数
            max = Math.max(max, blockTask);
        }
        res[0] = tasks[tasks.length - 1][0] + blockTask;
        res[1] = max;
        return res;
    }

    public static void main(String[] args) {
        int[][] tasks = {
            {1, 3},
            {2, 3},
            {3, 3}
        };
        final int[] ints = taskQueue(tasks);
        System.out.println(Arrays.toString(ints));
    }
}
