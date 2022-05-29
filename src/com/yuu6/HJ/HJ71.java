package com.yuu6.HJ;

import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HJ71 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pattern;
        while((pattern = br.readLine()) != null) {
            pattern = pattern.trim();
            String str = br.readLine().trim();
            System.out.println(isMatch(pattern, str));
        }
    }

    private static boolean isMatch(String p, String s) {
        int plen = p.length();
        int slen = s.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        // 字符串和模式串均为空，直接匹配上
        dp[0][0] = true;
        // 模式串为空，全都不匹配，j=0时全部为false
        // i=0时，只有在模式串为*的时候才能匹配
        for(int j = 1; j <= plen; j++){
            if(p.charAt(j - 1) == '*')
                dp[0][j] = true;
            else
                break;
        }
        for(int i = 1; i <= slen; i++){
            for(int j = 1; j <= plen; j++){
                if(p.charAt(j - 1) == '*' && (Character.isDigit(s.charAt(i - 1)) ||Character.isLetter(s.charAt(i - 1))))
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i - 1][j - 1];
                else if(p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 1];
                else if(p.charAt(j - 1) == '?' && (Character.isDigit(s.charAt(i - 1)) ||Character.isLetter(s.charAt(i - 1))) || Character.toLowerCase(p.charAt(j - 1)) == Character.toLowerCase(s.charAt(i - 1)))
                    dp[i][j] = dp[i - 1][j - 1];
            }
        }
        return dp[slen][plen];
    }
}