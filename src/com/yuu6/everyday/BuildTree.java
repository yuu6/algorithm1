package com.yuu6.everyday;

import java.util.Arrays;

public class BuildTree {
    /**
     * leetcode 105
     * 给定两个整数数组 preorder 和 inorde，其preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildByIndex(preorder, inorder, 0, preorder.length, 0, inorder.length);

    }

    private TreeNode buildByIndex(int[] preorder, int[] inorder, int from1, int to1, int from2, int to2) {
        if (from1 >= to1 || from2 >= to2){
            return null;
        }


        // 找到root
        int rootVal = preorder[from1];
        TreeNode root = new TreeNode(rootVal);
        if(to1 - from1 == 1){
            return root;
        }

        // 处理中序
        int inOrderRootIndex = getIndexOfArr(inorder, rootVal, from2, to2);

        root.left = buildByIndex(preorder, inorder, from1 + 1, from1 + inOrderRootIndex - from2  + 1, from2, inOrderRootIndex);
        root.right = buildByIndex(preorder, inorder, from1 + inOrderRootIndex - from2  + 1, to1, inOrderRootIndex + 1, to2);

        return root;
    }

    private int getIndexOfArr(int[] arr, int val, int begin, int end){
        for (int i = begin; i < end; i++) {
            if (arr[i] == val){
                return i;
            }
        }
        return -1;
    }

}
