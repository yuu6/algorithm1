package com.yuu6.everyday;

import java.util.HashMap;

public class PathSum {

        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return 0;
            }

            int ret = rootSum(root, targetSum);
            ret += pathSum(root.left, targetSum);
            ret += pathSum(root.right, targetSum);
            return ret;
        }

        // 只能一直减
        public int rootSum(TreeNode root, int targetSum) {
            int ret = 0;

            if (root == null) {
                return 0;
            }
            int val = root.val;
            if (val == targetSum) {
                ret++;
            }

            ret += rootSum(root.left, targetSum - val);
            ret += rootSum(root.right, targetSum - val);
            return ret;
        }



    public static void main(String[] args) {
        PathSum pathSum = new PathSum();

    }

}
