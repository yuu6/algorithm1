package com.yuu6.HJ;

/**
 * @Author: yuu6
 * @Date: 2022/05/29/下午3:04
 */
import java.util.Scanner;
public class HJ107{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNextDouble()){
            double num = input.nextDouble();
            double x = 1.0;
            for (; Math.abs(Math.pow(x,3)-num)>1e-3; x=x-((Math.pow(x,3)-num)/(3*Math.pow(x,2))));
            System.out.println(String.format("%.1f", x));
        }
    }
}