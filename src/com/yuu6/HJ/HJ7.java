package com.yuu6.HJ;

import java.util.Scanner;

/**
 * double 四舍五入
 * @Author: yuu6
 * @Date: 2022/05/28/下午7:30
 */
public class HJ7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String aDoubleStr = in.next();
        String[] strs = aDoubleStr.split("\\.");
        Integer i = Integer.parseInt(strs[0]);
        if (strs[1].charAt(0) >= '5'){
            System.out.println(i + 1);
        }else{
            System.out.println(i);
        }
    }
}
