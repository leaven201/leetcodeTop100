package 剑指offers.斐波那契数列;

/**
 * @author LinZebin
 * @date 2019-10-03 15:54
 */
public class Solution {

    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
