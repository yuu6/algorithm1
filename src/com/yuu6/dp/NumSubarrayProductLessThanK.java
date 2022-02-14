package com.yuu6.dp;

public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0, r = 0;
        int res = 1;
        int num = 0;
        for (; r < nums.length; r++) {
            // 滑动窗口
            // 前缀和
            res *= nums[r];
            while (res >= k && l <= r){
                res /= nums[l];
                l++;
            }
            if (res < k) num += (r - l + 1);
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;
        NumSubarrayProductLessThanK numSubarrayProductLessThanK = new NumSubarrayProductLessThanK();
        int res = numSubarrayProductLessThanK.numSubarrayProductLessThanK(nums, k);
        System.out.println(res);
    }
}
