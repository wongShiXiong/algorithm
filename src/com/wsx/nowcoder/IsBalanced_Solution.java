package com.wsx.nowcoder;

public class IsBalanced_Solution {
    public boolean IsBalanced_Solution(TreeNode1 root) {
        if(root == null){
            return true;
        }
        return Math.abs(treeDeep(root.left) - treeDeep(root.right)) <=1 &&
                IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);

    }
    private int treeDeep(TreeNode1 root){
        if(root != null){
            return 0;
        }
        return Math.max(treeDeep(root.left),treeDeep(root.right)) + 1;
    }
}
