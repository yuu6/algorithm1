package com.yuu6.HJ;

import java.util.Scanner;

/**
 * 分解质数因子
 * @Author: yuu6
 * @Date: 2022/05/28/下午7:15
 */
public class HJ6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int aInt = in.nextInt();
            while(aInt != 1){
                for (int i = 2; i <= aInt; i++) {
                    if (aInt % i ==0){
                        aInt /= i;
                        System.out.printf(i + " ");
                        break;
                    }else if(i *i > aInt){
                        System.out.println(aInt + " ");
                        aInt =1;
                        break;
                    }
                }
            }
            System.out.println();
        }
    }


}
