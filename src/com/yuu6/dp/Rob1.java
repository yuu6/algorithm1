package com.yuu6.dp;

public class Rob1 {

    public int rob(int[] nums) {
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

    public static void main(String[] args) {
        Rob1 rob = new Rob1();
        int[] nums = new int[]{3, 1, 3, 100};
        int res = rob.rob(nums);
        System.out.println(res);
    }
}
