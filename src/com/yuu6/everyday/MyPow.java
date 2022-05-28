package com.yuu6.everyday;

/**
 * 实现pow函数
 *
 * @Author: yuu6
 * @Date: 2022/05/26/上午8:21
 */
public class MyPow {
    public double myPow(double x, int n) {
        int absN = Math.abs(n);
        double res = doPow(x, absN);
        return n < 0 ? 1 / res : res;
    }

    private double doPow(double x, int absN) {
        if (absN == 1){
            return x;
        }else if(absN ==0){
            return 1;
        }
        int t = absN / 2;
        double res = doPow(x, t);
        return absN %2 == 0? res * res : res * res * x;
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        double res = myPow.myPow(2, -2);
        System.out.println(res);
    }
}
