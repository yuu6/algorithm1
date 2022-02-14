package com.yuu6.dp;

public class NumMatrix {
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
                } else if (i > 0 && j == 0) {
                    dp[i][j] = dp[i - 1][j] + matrix[i][j];
                } else if (i == 0 && j > 0) {
                    dp[i][j] = dp[i][j - 1] + matrix[i][j];
                } else {
                    dp[i][j] = matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (col1 == 0 && row1 == 0) return dp[row2][col2];
        if (col1 == 0) return dp[row2][col2] - dp[row1 - 1][col2];
        if (row1 == 0) return dp[row2][col2] - dp[row2][col1 - 1];
        return dp[row2][col2] - dp[row1 - 1][col1 - 1] - (dp[row1 - 1][col2] - dp[row1 - 1][col1 - 1]) - (dp[row2][col1 - 1] - dp[row1 - 1][col1 - 1]);
    }
}
