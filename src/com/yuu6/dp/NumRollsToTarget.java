package com.yuu6.dp;

public class NumRollsToTarget {
    private static final int MOD = 1000000007;
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[31][1001];
        int min = Math.min(f, target);
        for (int i = 1; i <= min; i++) {
            dp[1][i] = 1;
        }
        int targetMax = d * f;
        for (int i = 2; i <= d; i++) {
            for (int j = i; j <= targetMax; j++) {
                for (int k = 1; j - k >= 0 && k <= f; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                }
            }
        }
        return dp[d][target];
    }

}
