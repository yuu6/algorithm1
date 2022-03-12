package com.yuu6.everyday;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int res = 0;

        while(x > 0 || y > 0){
            int temp = x % 2;
            int temp2 = y % 2;

            if (temp - temp2 != 0){
                res += 1;
            }
            x /= 2;
            y /= 2;
        }

        return res;
    }

    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();
        int res = hammingDistance.hammingDistance(1, 4);
        System.out.println(res);
    }
}
