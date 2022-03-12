package com.yuu6.everyday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 */
public class SubSets {
    private List<List<Integer>> sets = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> tempList = new LinkedList<>();
        step(nums, 0, nums.length, tempList);
        return sets;
    }

    private void step(int[] nums, int i, int length, LinkedList<Integer> tempList) {
        if (i == length){
            ArrayList<Integer> temp1 = new ArrayList<>(tempList);
            sets.add(temp1);
            return;
        }

        tempList.add(nums[i]);
        step(nums, i + 1, length, tempList);
        tempList.pollLast();
        step(nums, i + 1, length, tempList);
    }

    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> sets = subSets.subsets(nums);
        System.out.println(sets);
    }
}
