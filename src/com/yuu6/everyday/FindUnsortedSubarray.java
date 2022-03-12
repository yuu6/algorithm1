package com.yuu6.everyday;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] min = getMin(nums);
        int[] max = getMax(nums);

        int l = 0, r = nums.length - 1;

        while(l <= r && nums[l] == min[l] ){
            l++;
        }
        if (l > r){
            return 0;
        }

        while(nums[r] == max[r]){
            r--;
        }

        return r - l + 1;
    }

    private int[] getMin(int[] nums) {
        int min = nums[nums.length - 1];
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0 ; i--) {
            if (min > nums[i]){
                res[i] = nums[i];
                min = nums[i];
            }else{
                res[i] = min;
            }
        }
        return res;
    }

    private int[] getMax(int[] nums) {
        int max = nums[0];
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]){
                res[i] = nums[i];
                max = nums[i];
            }else{
                res[i] = max;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindUnsortedSubarray find = new FindUnsortedSubarray();
        int[] arr = new int[]{2};
        int res = find.findUnsortedSubarray(arr);
        System.out.println(res);
    }
}
