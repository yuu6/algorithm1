package com.yuu6.everyday;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] exists = new boolean[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            exists[nums[i]] = true;
        }
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i < nums.length + 1; i++) {
            if (!exists[i]) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1};
        FindDisappearedNumbers find = new FindDisappearedNumbers();
        List<Integer> res = find.findDisappearedNumbers(nums);
        System.out.println(res);
    }
}
