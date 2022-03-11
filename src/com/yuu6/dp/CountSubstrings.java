package com.yuu6.dp;

public class CountSubstrings {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int i = s.length() - 1; i >= 0 ; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j -i ==1){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                res += dp[i][j] ? 1 : 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountSubstrings countSubstrings = new CountSubstrings();
        int res = countSubstrings.countSubstrings("abc");
        System.out.println(res);
    }
}
