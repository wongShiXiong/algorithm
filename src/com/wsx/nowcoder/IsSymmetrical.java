package com.wsx.nowcoder;

import javax.swing.tree.TreeNode;

public class IsSymmetrical {
}
/*思路：首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
 * 左子树的右子树和右子树的左子树相同即可，采用递归
 * 非递归也可，采用栈或队列存取各级子树根节点
 */
/*
class Solution312 {
    boolean isSymmetrical(TreeNode1 pRoot)
    {
        if(pRoot == null){
            return true;
        }
        return comRoot(pRoot.left, pRoot.right);
    }
    private boolean comRoot(TreeNode1 left, TreeNode1 right) {
        // TODO Auto-generated method stub
        if(left == null) return right==null;
        if(right == null) return false;
        if(left.val != right.val) return false;
        return comRoot(left.right, right.left) && comRoot(left.left, right.right);
    }
}*/
class Solution312 {
    boolean isSymmetrical(TreeNode1 pRoot)
    {
        if(pRoot == null){
            return true;
        }
        return comp(pRoot.left,pRoot.right);
    }
    public Boolean comp(TreeNode1 left,TreeNode1 right){
        if(left == null) return right == null;
        if(right == null) return false;
        if(left.val != right.val) return false;
        return comp(left.left,right.right) && comp(left.right,right.left);
    }
}