package com.yuu6.HJ;

import java.util.Scanner;

/**
 * @Author: yuu6
 * @Date: 2022/05/29/下午4:37
 */
public class HJ69 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        int[][] a = new int[n][m];
        int[][] b = new int[m][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                b[i][j] = in.nextInt();
            }
        }

//        int[][] c = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int tempRes = 0;
                for (int l = 0; l < m; l++) {
                    tempRes += a[i][l]*b[l][j];
                }
//                c[i][j] = tempRes;
                System.out.print(tempRes + " ");
            }
            System.out.println();
        }

    }
}
