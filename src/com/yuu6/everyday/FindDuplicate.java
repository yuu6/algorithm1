package com.yuu6.everyday;

/**
 * 快慢指针找寻重复的节点
 * @Author: yuu6
 * @Date: 2022/05/23/下午10:59
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);

        int i = 0;
        while(i != slow){
            i = nums[i];
            slow = nums[slow];
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,2};
        FindDuplicate findDuplicate = new FindDuplicate();
        int res = findDuplicate.findDuplicate(nums);
        System.out.println(res);
    }
}
