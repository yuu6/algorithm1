package com.yuu6.dp;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        int sum = 1;
        for (int i = 0; i < nums.length; i++) {
            pre[i] = sum;
            sum *= nums[i];
        }

        int sum2 = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            post[i] = sum2;
            sum2 *= nums[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = pre[i] * post[i];
        }
        return res;
    }

    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        int[] nums = new int[]{1, 2, 3, 4};
        int[] res = productExceptSelf.productExceptSelf(nums);
        for (int num :res) {
            System.out.print(num);
        }
    }
}
