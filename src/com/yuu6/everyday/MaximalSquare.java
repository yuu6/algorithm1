package com.yuu6.everyday;

/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] - '0' == 0){
                    dp[i][j] = 0;
                }else{
                    if (i  == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i- 1][j - 1]) + 1;
                    }
                }
                if (dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        return max * max;
    }

}