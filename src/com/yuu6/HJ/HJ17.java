package com.yuu6.HJ;

import jdk.nashorn.internal.runtime.regexp.joni.Matcher;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 坐标移动
 * @Author: yuu6
 * @Date: 2022/05/28/下午8:56
 */
public class HJ17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        List<String> strs = getValidStr(str);
        int row = 0;
        int col = 0;
        for (int i = 0; i < strs.size(); i++) {
            int aInt = Integer.parseInt(strs.get(i).substring(1));
            switch (strs.get(i).charAt(0)) {
                case 'A':
                    row -= aInt;
                    break;
                case 'S':
                    col -= aInt;
                    break;
                case 'W':
                    col += aInt;
                    break;
                case 'D':
                    row += aInt;
                    break;
            }
        }
        System.out.println(row +","+ col);
    }


    private static List<String> getValidStr(String str) {
        String[] arr = str.split(";");
        List<String> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String tempStr = arr[i];

            String pattern = "^[ASWD]{1}[0-9]+$";

            boolean isMatch = Pattern.matches(pattern, tempStr);
            if (isMatch){
                res.add(tempStr);
            }
        }
        return res;
    }
}
