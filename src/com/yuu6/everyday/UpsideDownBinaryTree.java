package com.yuu6.everyday;

/**
 * Leetcode 156. 上下翻转二叉树
 * @Author: yuu6
 * @Date: 2022/05/25/上午8:11
 */
public class UpsideDownBinaryTree {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // 右兄弟
        TreeNode right = null;
        // 之前的父节点
        TreeNode father = null;
        while(root != null){
            //为了继续遍历，先记录下原来的左子节点防止丢失
            TreeNode left = root.left;
            //当前节点的左子节点更新为父节点的右子节点
            root.left = right;
            //记录下当前节点的右子节点
            right = root.right;
            //当前节点的右子节点更新为原父节点
            root.right = father;
            //记录下当前节点作为下一个待遍历节点的父节点（新右子节点）
            father = root;

            root = left;
        }
        //最终root=null,father指向的是最终的根节点
        return father;
    }
}
