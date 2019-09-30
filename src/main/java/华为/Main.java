package 华为;

import java.util.Scanner;

/**
 * @author LinZebin
 * @date 2019-09-25 19:25
 */
public class Main {

    public static void func(int[] nums, int[][] pros) {
        for (int i = 0; i < pros.length; i++) {
            int[] pro = pros[i];
            // 查询
            if (pro[0] == 0) {
                final int res = query(nums, pro[1], pro[2]);
                System.out.println(res);
            } else {
                // 更新
                update(nums, pro[1], pro[2]);
            }
        }
    }

    private static void update(int[] nums, int index, int plus) {
        nums[index - 1] = nums[index - 1] + plus;
    }

    private static int query(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start - 1; i < end; i++) {
            sum += nums[i];
        }
        return sum / (end - start + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[][] pros = new int[m][3];
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            if (s1[0].equals("Q")) {
                pros[i][0] = 0;
            } else {
                pros[i][0] = 1;
            }
            pros[i][1] = Integer.valueOf(s1[1]);
            pros[i][2] = Integer.valueOf(s1[2]);
        }
        func(nums, pros);


    }

}
