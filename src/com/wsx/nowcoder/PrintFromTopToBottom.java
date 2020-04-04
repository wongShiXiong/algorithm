package com.wsx.nowcoder;

import java.util.ArrayList;

public class PrintFromTopToBottom {
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

        final Solution302 solution302 = new Solution302();
        final ArrayList<Integer> integers = solution302.PrintFromTopToBottom(root);
        System.out.println(integers);
    }
}

class Solution302 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode1 root) {
        ArrayList<Integer> list = new ArrayList();
        ArrayList<TreeNode1> treelist = new ArrayList();
        if(root == null){
            return list;
        }
        treelist.add(root);
        while(treelist.size() != 0){
            TreeNode1 temp = treelist.remove(0);
            if(temp.left != null){
                treelist.add(temp.left);
            }
            if(temp.right != null){
                treelist.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
    }
}










































/*class Solution302 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode1 root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode1> queue = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode1 temp = queue.remove(0);
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
    }
}*/
