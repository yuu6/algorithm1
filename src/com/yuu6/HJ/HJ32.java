package com.yuu6.HJ;

import java.util.Scanner;

public class HJ32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            boolean[][] dp = new boolean[str.length()][str.length()];

            for (int i = 0; i < str.length(); i++) {
                dp[i][i] = true;
            }

            int max = 0;
            for (int i = str.length() - 1; i >= 0 ; i--) {
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(i) == str.charAt(j) && (dp[i+1][j-1] || j-i==1)){
                        dp[i][j] = true;
                        if (j -i + 1 > max){max = j-i+ 1;}
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
            System.out.println(max);
        }
    }
}