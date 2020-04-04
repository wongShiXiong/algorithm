package com.wsx.nowcoder;

import java.util.Stack;

public class ConvertBSTToBiList {
}
class Solution803 {
    public TreeNode1 Convert(TreeNode1 pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        Stack<TreeNode1> stack = new Stack<TreeNode1>();
        boolean isFirst = true;
        TreeNode1 p = pRootOfTree;
        TreeNode1 pre = null;
        while(p!=null || !stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                pRootOfTree = p;
                pre = pRootOfTree;
                isFirst = false;
            }else{
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return pRootOfTree;
    }
}