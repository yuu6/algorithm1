package com.yuu6.dp;

import java.util.HashMap;

/**
 * 525 连续数组
 */
public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count0 = 0;
        int count1 = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count0 += 1;
            if (nums[i] == 1) count1 += 1;
            int diff = count0 - count1;
            if (map.containsKey(diff)){
                res = Math.max(res, i - map.get(diff));
            }else {
                map.put(diff, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindMaxLength findMaxLength = new FindMaxLength();
        int[] nums = new int[]{0, 1, 0};
        System.out.println(findMaxLength.findMaxLength(nums));
    }
}
