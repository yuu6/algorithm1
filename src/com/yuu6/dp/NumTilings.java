package com.yuu6.dp;

public class NumTilings {
    public int numTilings(int n) {
        int[] dp = new int[n + 1];
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumTilings numTilings = new NumTilings();
        System.out.println(numTilings.numTilings(4));
    }
}
