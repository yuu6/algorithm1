package com.yuu6.HJ;

import java.util.*;


public class HJ65 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str1 = in.next();
            String str2 = in.next();

            String res = getRes(str1, str2);
            System.out.println(res);
        }
    }

    private static String getRes(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];

        for (int i = 0; i < str2.length(); i++) {
            dp[0][i] = str1.charAt(0) == str2.charAt(i) ? 1 : 0;
        }
        for (int i = 0; i < str1.length(); i++) {
            dp[i][0] = str1.charAt(i) == str2.charAt(0) ? 1 : 0;
        }
        int max = 0;
        String maxStr = "";
        List<String> strSet = new ArrayList<>();
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max){
                        strSet.clear();
                        max = dp[i][j];
                        maxStr = str1.substring(i-max + 1, i + 1);
                        strSet.add(maxStr);
                    }else if(dp[i][j] == max){
                        maxStr = str1.substring(i-max + 1, i + 1);
                        strSet.add(maxStr);
                    }
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        if (str1.length() <= str2.length()){
            if (max == 1){
                return str1.substring(0, 1);
            }
            String preStr = "";
            int index = str1.length();
            for (int i = 0; i < strSet.size(); i++) {
                if (index > str1.indexOf(strSet.get(i))){
                    preStr = strSet.get(i);
                    index =  str1.indexOf(strSet.get(i));
                }
            }
            return preStr;
        }else {
            if (max == 1){
                return str2.substring(0, 1);
            }
            String preStr = "";
            int index = str2.length();
            for (int i = 0; i < strSet.size(); i++) {
                if (index > str2.indexOf(strSet.get(i))){
                    preStr = strSet.get(i);
                    index =  str2.indexOf(strSet.get(i));

                }
            }
            return preStr;
        }
    }
}