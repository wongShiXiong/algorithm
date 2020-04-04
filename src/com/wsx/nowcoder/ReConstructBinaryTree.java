package com.wsx.nowcoder;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReConstructBinaryTree {
    public static void main(String[] args) {
        int [] pre ={1,2,4,7,3,5,6,8};
        int [] in = {4,7,2,1,5,3,8,6};
        final Solution501 solution501 = new Solution501();
        final TreeNode1 treeNode1 = solution501.reConstructBinaryTree(pre, in);
        System.out.println(treeNode1.val);
        final Solution302 solution302 = new Solution302();
        final ArrayList<Integer> integers = solution302.PrintFromTopToBottom(treeNode1);
        System.out.println(integers);
    }
}
class Solution501 {
   /* public TreeNode1 reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode1 root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode1 reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode1 root=new TreeNode1(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }

        return root;
    }*/
   // 缓存中序遍历数组每个值对应的索引
/*   private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode1 reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++)
            indexForInOrders.put(in[i], i);
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode1 reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        TreeNode1 root = new TreeNode1(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }*/



        public TreeNode1 reConstructBinaryTree(int [] pre,int [] in) {
            if(pre.length == 0){
                return null;
            }
            int rootVal = pre[0];

            if(pre.length == 1){
                return new TreeNode1(rootVal);
            }

            TreeNode1 root = new TreeNode1(rootVal);
            int rootIndex = 0;
            for(int i = 0;i<in.length;i++){
                if(rootVal == in[i]){
                    rootIndex = i;
                    break;
                }
            }
            root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,rootIndex +1),Arrays.copyOfRange(in,0,rootIndex));
            root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,rootIndex + 1,pre.length),Arrays.copyOfRange(in,rootIndex+1,in.length));
            return root;
        }

}