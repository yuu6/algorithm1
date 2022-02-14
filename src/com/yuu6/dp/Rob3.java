package com.yuu6.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归 + 备忘录的形式
 */
public class Rob3 {
    private Map<TreeNode, Integer> resMap = new HashMap<>();

    public int rob(TreeNode root) {
        if (resMap.containsKey(root)){
            return resMap.get(root);
        }
        int res = 0;
        if (root == null) {
            return res;
        }
        if (root.left != null && root.right != null) {
            int selectRoot = root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right);
            int notSelectRoot = rob(root.left) + rob(root.right);
            res =  Math.max(selectRoot, notSelectRoot);
        }
        if (root.left == null && root.right != null) {
            int selectRoot = root.val + rob(root.right.left) + rob(root.right.right);
            int notSelectRoot = rob(root.left) + rob(root.right);
            res = Math.max(selectRoot, notSelectRoot);
        }
        if (root.left != null && root.right == null) {
            int selectRoot = root.val + rob(root.left.left) + rob(root.left.right);
            int notSelectRoot = rob(root.left) + rob(root.right);
            res = Math.max(selectRoot, notSelectRoot);
        }
        if (root.left == null && root.right == null) {
            res = root.val;
        }
        resMap.put(root, res);
        return res;
    }
}
