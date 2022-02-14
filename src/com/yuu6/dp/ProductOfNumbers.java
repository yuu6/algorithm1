package com.yuu6.dp;

import java.util.ArrayList;
class ProductOfNumbers {

    private ArrayList<Integer> arrs;
    private Integer len;
    private Integer res;


    public ProductOfNumbers() {
        arrs = new ArrayList<>();
        arrs.add(1);
        len = 0;
        res = 1;
    }

    public void add(int num) {
        if (num == 0){
            len = 0;
            arrs.clear();
            arrs.add(1);
            res = 1;
        }else {
            res *= num;
            arrs.add(res);
            len++;
        }
    }

    public int getProduct(int k) {
        if (len < k) return 0;
        return arrs.get(len) / arrs.get(len - k);
    }
}