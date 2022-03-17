package com.yuu6.everyday;

import java.util.Arrays;
import java.util.TreeMap;

public class TopKF {
    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> fMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = fMap.getOrDefault(nums[i], 0);
            fMap.put(nums[i], n + 1);
        }
        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            int max = Integer.MIN_VALUE;
            Integer maxKey = null;
            for (Integer key :fMap.keySet()) {
                if (fMap.get(key) > max){
                    max = fMap.get(key);
                    maxKey = key;
                }
            }
            fMap.remove(maxKey);
            res[i] = maxKey;
        }
        return res;
    }

    public static void main(String[] args) {
        TopKF topKF = new TopKF();
        int[] nums = new int[]{3, 1, 6, 7, 2, 1, 6};
        int[] res = topKF.topKFrequent(nums, 2);
        Arrays.stream(res).forEach(t ->{
            System.out.println(t);
        });
    }
}
