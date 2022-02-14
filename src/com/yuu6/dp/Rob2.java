package com.yuu6.dp;

public class Rob2 {
    public int doRob(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
            if (i >= 1){
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
        }
        for (int j = 2; j < nums.length; j++) {
            dp[j] = Math.max(dp[j - 1],dp[j - 2] + nums[j]);
        }
        return dp[nums.length - 1];
    }

    public int rob(int[] nums) {
        int[] nums1 = new int[nums.length - 1];
        int[] nums2 = new int[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            nums1[i] = nums[i];
            nums2[i] = nums[i + 1];
        }
        int res1 = doRob(nums1);
        int res2 = doRob(nums2);
        return Math.max(res1, res2);
    }
}
