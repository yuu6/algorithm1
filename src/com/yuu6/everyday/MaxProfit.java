package com.yuu6.everyday;

public class MaxProfit {

    public int maxProfit(int[] prices) {

        int[] dp = new int[prices.length];
        dp[0] = 0;
        int[] min = new int[prices.length];
        int minVal = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (minVal > prices[i]){
                min[i] = prices[i];
                minVal = prices[i];
            }else{
                min[i] = minVal;
            }
        }

        for (int i = 1; i < prices.length; i++) {
            if (minVal > prices[i]){
                min[i] = prices[i];
                minVal = prices[i];
            }else{
                min[i] = minVal;
            }

            dp[i] = Math.max(dp[i - 1], prices[i] - min[i - 1]);
        }
        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = new int[]{7,6,4,3,1};
        int res = maxProfit.maxProfit(prices);
        System.out.println(res);
    }
}
