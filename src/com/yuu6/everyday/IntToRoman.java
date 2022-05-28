package com.yuu6.everyday;

/**
 * 整数转化为罗马数字
 *
 * @Author: yuu6
 * @Date: 2022/05/25/下午10:15
 */
public class IntToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        while(num > 0) {
            num = getNextNum(sb, num);
        }
        return sb.toString();
    }

    private int getNextNum(StringBuilder sb, int num) {
        if (num >= 1000){
            sb.append("M");
            return num - 1000;
        }else if(num >= 900){
            sb.append("CM");
            return num - 900;
        }else if(num >= 500){
            sb.append("D");
            return num - 500;
        }else if(num >= 400){
            sb.append("CD");
            return num - 400;
        }else if(num >= 100){
            sb.append("C");
            return num - 100;
        }else if(num >= 90){
            sb.append("XC");
            return num - 90;
        }else if(num >= 50){
            sb.append("L");
            return num - 50;
        }else if(num >= 40){
            sb.append("XL");
            return num - 40;
        }else if(num >= 10){
            sb.append("X");
            return num - 10;
        }else if(num >= 9){
            sb.append("IX");
            return num - 9;
        }else if(num >= 5){
            sb.append("V");
            return num - 5;
        }else if(num >= 4){
            sb.append("IV");
            return num - 4;
        }else if(num >= 3){
            sb.append("III");
            return num - 3;
        }else if(num >= 2){
            sb.append("II");
            return num - 2;
        }else{
            sb.append("I");
            return num - 1;
        }
    }

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        System.out.println(intToRoman.intToRoman(3));
        System.out.println(intToRoman.intToRoman(4));
        System.out.println(intToRoman.intToRoman(9));
        System.out.println(intToRoman.intToRoman(58));
        System.out.println(intToRoman.intToRoman(1994));

    }
}
