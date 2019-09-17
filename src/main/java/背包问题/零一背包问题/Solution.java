package 背包问题.零一背包问题;


/**
 * @author LinZebin
 * @date 2019-09-16 15:54
 */
public class Solution {

    private int maxValue(int[] weights, int[] values, int V) {
        // 商品数
        int N = weights.length;
        int[][] dp = new int[N + 1][V + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                if (j >= weights[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][V];
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        int[] weights = {1,2,3,4};
        int[] values = {2,4,4,5};
        int V = 5;
        final int res = s.maxValue(weights, values, V);
        System.out.println(res);

    }
}
