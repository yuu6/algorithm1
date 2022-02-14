package com.yuu6.dp;

/**
 * 爬楼梯最小花费
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[cost.length];
    }


    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int[] arrs = new int[]{10, 15, 20};

        System.out.println(minCostClimbingStairs.minCostClimbingStairs(arrs));
    }
}
