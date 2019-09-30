package top100.easy.买卖股票的最佳时机121;

/**
 * @author LinZebin
 * @date 2019-09-25 14:47
 */
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        //初始化为最大的整数！
        int preMin = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < preMin) {
                preMin = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i] - preMin);
        }
        return maxProfit;
    }
}
