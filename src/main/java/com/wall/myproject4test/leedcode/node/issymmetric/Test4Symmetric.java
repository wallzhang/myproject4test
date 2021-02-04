package com.wall.myproject4test.leedcode.node.issymmetric;
//给定一个二叉树，检查它是否是镜像对称的。
//
//
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// 进阶：
//
// 你可以运用递归和迭代两种方法解决这个问题吗？
// Related Topics 树 深度优先搜索 广度优先搜索

/**
 * zhang.zhiwen
 */
public class Test4Symmetric {
    public static void main(String[] args) {
    // 测试用例:[1,2,2,null,3,null,3]
        TreeNode node5 = new TreeNode(3,null,null);
        TreeNode node4 = new TreeNode(3,null,null);
        TreeNode node3 = new TreeNode(2,null,node5);
        TreeNode node2 = new TreeNode(2,null,node4);
        TreeNode node1 = new TreeNode(2,node2,node3);
        boolean isSymmetric = new Test4Symmetric().isSymmetric(node1);
        System.out.println("isSymmetric:"+isSymmetric);
    }
    public boolean isSymmetric(TreeNode root) {
        return checkTree(root, root);
    }
    public boolean checkTree(TreeNode p,TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val == q.val && checkTree(p.left, q.right) && checkTree(p.right, q.left);
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
