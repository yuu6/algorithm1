package com.yuu6.everyday;

/**
 * 描述：把二叉搜索树转换为累加树
 *
 * @Author: yuu6
 * @Date: 2022/05/24/上午8:17
 */
public class ConvertBST {

    private static int  num = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            //遍历右子树
            convertBST(root.right);
            //遍历顶点
            root.val = root.val + num;
            num = root.val;
            //遍历左子树
            convertBST(root.left);
            return root;
        }
        return null;
    }

}
