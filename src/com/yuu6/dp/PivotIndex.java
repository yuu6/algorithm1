package com.yuu6.dp;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            pre[i] = sum;
            sum += nums[i];
        }

        int sum2 = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            post[i] = sum2;
            sum2 += nums[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (pre[i] == post[i]){
                return i;
            }
        }
        return -1;
    }
}
