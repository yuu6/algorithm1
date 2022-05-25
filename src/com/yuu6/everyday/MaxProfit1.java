package com.yuu6.everyday;

import java.util.Arrays;

/**
 * 动态规划
 *  买股票，最后一天的状态
 *
 * @Author: yuu6
 * @Date: 2022/05/23/下午10:21
 */
public class MaxProfit1 {
    public int maxProfit(int[] prices) {
        int[] buy = new int[prices.length];
        Arrays.fill(buy, 0);

        int[] sell = new int[prices.length];
        Arrays.fill(sell, 0);

        int[] cool = new int[prices.length];
        Arrays.fill(cool, 0);

        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(cool[i - 1] - prices[i], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
            cool[i] = Math.max(Math.max(sell[i - 1],  cool[i - 1]), buy[i - 1]);
        }
        return sell[prices.length - 1];
    }


    public static void main(String[] args) {
        MaxProfit1 profit1 = new MaxProfit1();
        int[] prices = new int[]{1,2,3,0,2};
        int res = profit1.maxProfit(prices);
        System.out.println(res);
    }


}
