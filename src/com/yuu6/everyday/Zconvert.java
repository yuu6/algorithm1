package com.yuu6.everyday;

import java.util.*;

/**
 * 多分析题目含义
 *
 * @Author: yuu6
 * @Date: 2022/05/25/上午8:49
 */
public class Zconvert {
    public String convert(String s, int numRows) {
        List<StringBuilder> sbs = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            sbs.add(new StringBuilder());
        }
        if(s.length() <= numRows || numRows == 1){
            return s;
        }
        int cycleNum = numRows + numRows - 2;
        for (int i = 0; i < s.length(); i++) {
            int temp = i % cycleNum;
            int row = 0;
            if (temp + 1 > numRows){
                row = numRows - (temp + 2 - numRows);
            }else{
                row = temp;
            }
            StringBuilder sb = sbs.get(row);
            sb.append(s.charAt(i));
        }
        StringBuilder res = sbs.get(0);
        for (int i = 1; i < numRows; i++) {
            res.append(sbs.get(i).toString());
        }
        return res.toString();
    }



    public static void main(String[] args) {
        Zconvert zconvert = new Zconvert();
        String res = zconvert.convert("PAYPALISHIRING", 3);
        System.out.println(res);
    }

}
