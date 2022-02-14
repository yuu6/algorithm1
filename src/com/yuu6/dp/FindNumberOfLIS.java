package com.yuu6.dp;

import java.util.Arrays;

/**
 * 找寻最长递增子序列的个数
 */
public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int res = 1;
        int maxNum = 1;
        int maxLen = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            int tempInt = nums[i];
            int firstMin = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < tempInt) {
                    firstMin = j;
                    break;
                }
            }
            if(firstMin != -1) {
                if (dp[firstMin] + 1 > maxLen){
                    res *= maxNum;
                    maxNum = 1;
                }else if(dp[firstMin] + 1 == maxLen){
                    maxNum += 1;
                }
                maxLen = Math.max(dp[firstMin] + 1, maxLen);
                dp[i] = maxLen;
            }else if(maxLen == 1){
                maxNum += 1;
            }
        }

        return res * maxNum;
    }

    public static void main(String[] args) {
        FindNumberOfLIS findNumberOfLIS = new FindNumberOfLIS();
        int[] nums = new int[]{1,2,4,3,5,4,7,2};
        System.out.println(findNumberOfLIS.findNumberOfLIS(nums));
    }
}
