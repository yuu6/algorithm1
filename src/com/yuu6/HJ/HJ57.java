package com.yuu6.HJ;

import java.util.Scanner;

/**
 * @Author: yuu6
 * @Date: 2022/05/29/下午2:50
 */
public class HJ57 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str1 = in.next();
            String str2 = in.next();

            StringBuilder  sb  =new StringBuilder();
            int jinwei = 0;
            for (int i = 0; i < Math.max(str1.length(), str2.length() ); i++) {
                int temp1 = str1.length() > i ? str1.charAt(str1.length() - 1 - i) - '0' : 0;
                int temp2 = str2.length() > i ? str2.charAt(str2.length() - 1 - i) - '0' : 0;

                sb.append((temp1 + temp2 + jinwei) % 10);
                jinwei = (temp1 + temp2 + jinwei) / 10;
            }
            if (jinwei != 0){
                sb.append(jinwei);
            }
            System.out.println(sb.reverse().toString());
        }
    }
}
