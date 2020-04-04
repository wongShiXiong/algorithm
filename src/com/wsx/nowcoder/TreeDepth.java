package com.wsx.nowcoder;


public class TreeDepth {
    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能
        TreeNode1 root = new TreeNode1(1);
        TreeNode1 node2 = new TreeNode1(3);
        TreeNode1 node3 = new TreeNode1(6);
        TreeNode1 node4 = new TreeNode1(8);
        TreeNode1 node5 = new TreeNode1(10);
        TreeNode1 node6 = new TreeNode1(14);

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.left = node2;
        root.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;

        final Solution101 solution101 = new Solution101();
        final int i = solution101.TreeDepth(root);
        System.out.println(i);
    }
}
class Solution101{
    public int TreeDepth(TreeNode1 root) {
        int leftCount = 0;
        int rightCount = 0;
        if(root == null){
            return 0;
        }
        if(root.left != null){
            leftCount = TreeDepth(root.left);
        }
        if(root.right != null){
            rightCount = TreeDepth(root.left);
        }
        return Math.max(leftCount,rightCount) + 1;
    }
}
class TreeNode1 {
    int val = 0;
    TreeNode1 left = null;
    TreeNode1 right = null;

    public TreeNode1(int val) {
        this.val = val;

    }

}