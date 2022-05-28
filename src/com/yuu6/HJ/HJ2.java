package com.yuu6.HJ;

import java.util.Scanner;

/**
 * @Author: yuu6
 * @Date: 2022/05/26/下午11:06
 */
public class HJ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        char c = in.nextLine().charAt(0);
        int res = 0;
        for (char tempC: str.toCharArray()) {
            if (c == Character.toUpperCase(tempC) || c == Character.toLowerCase(tempC)){
                res += 1;
            }
        }
        System.out.println(res);
    }
}
