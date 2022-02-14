package com.yuu6.dp;

/**
 * 1477. 找两个和为目标值且不重叠的子数组
 */
public class MinSumOfLengths {

    public int minSumOfLengths(int[] arr, int target) {
        // 以i为结尾的数组中和为target的最小长度
        int[] dp = new int[arr.length + 1];
        // 默认是不存在的
        dp[0] = 12313131;
        int res = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int sum = 0;

        for (r = 0; r < arr.length; r++) {
            // l , r 闭区间
            sum += arr[r];
            while (sum > target) {
                sum -= arr[l];
                l++;
            }
            if (sum == target) {
                int current = r - l + 1;
                dp[r + 1] = Math.min(current, dp[r]);
                // 虽然是闭区间，但是偏移了一位
                res = Math.min(res, current + dp[l]);
            } else {
                dp[r + 1] = dp[r];
            }
        }
        return res > arr.length ? -1 : res;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{7, 3, 4, 7};
        int[] arr = new int[]{3, 2, 2, 4, 3};
        int target = 3;
        MinSumOfLengths minSumOfLengths = new MinSumOfLengths();
        System.out.println(minSumOfLengths.minSumOfLengths(arr, target));
    }
}
