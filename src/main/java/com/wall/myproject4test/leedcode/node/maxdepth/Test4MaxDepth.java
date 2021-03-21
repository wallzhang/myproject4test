package com.wall.myproject4test.leedcode.node.maxdepth;
//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。

/**
 * zhang.zw
 */
public class Test4MaxDepth {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else {
            int leftDept = maxDepth(root.left);
            int rightDept = maxDepth(root.right);
            return Math.max(leftDept,rightDept) + 1;
        }


    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
