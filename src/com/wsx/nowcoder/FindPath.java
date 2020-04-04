package com.wsx.nowcoder;


import java.util.ArrayList;

public class FindPath {
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

        final Solution311 solution311 = new Solution311();
        final ArrayList<ArrayList<Integer>> arrayLists = solution311.FindPath(root, 21);
        System.out.println(arrayLists);
    }
}
class Solution311 {
    private ArrayList<ArrayList<Integer>> allarr= new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode1 root, int target) {
        if(root == null){
            return allarr;
        }
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.right == null && root.left == null){
            allarr.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size() - 1);
        return allarr;
    }
}
/*
class Solution311 {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode1 root, int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }
}*/
