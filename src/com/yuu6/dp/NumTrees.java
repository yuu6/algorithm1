package com.yuu6.dp;

/**
 * 二叉树的个数，卡特兰数
 */
public class NumTrees {
    public int numTrees(int n) {
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;

    }
}
