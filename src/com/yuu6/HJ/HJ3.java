package com.yuu6.HJ;

import java.util.Scanner;

/**
 * @Author: yuu6
 * @Date: 2022/05/26/下午11:15
 */
public class HJ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        boolean[] visited = new boolean[500];
        for (int i = 0; i < num; i++) {
            int temp = in.nextInt();
            visited[temp - 1] = true;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]){
                System.out.println(i + 1);
            }
        }
    }
}
