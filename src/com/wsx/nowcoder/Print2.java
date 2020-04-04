package com.wsx.nowcoder;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Print2 {
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
        final ArrayList<ArrayList<Integer>> print = Solution309.Print(root);
        System.out.println(print);

    }
}
class Solution309 {
    public static ArrayList<ArrayList<Integer> > Print(TreeNode1 pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return result;
        }
        Queue<TreeNode1> list = new LinkedList<TreeNode1>();
        ArrayList<Integer> listLayer = new ArrayList<Integer>();
        list.add(pRoot);
        int start = 0,end = 1;
        while(!list.isEmpty()){
            TreeNode1 node = list.remove();
            listLayer.add(node.val);
            start++;
            if(node.left != null){
                list.add(node.left);
            }
            if(node.right != null){
                list.add(node.right);
            }
            if(start == end){
                end = list.size();
                start = 0;
                result.add(listLayer);
                listLayer = new ArrayList<Integer>();
            }
        }
        return result;
    }
}
/*
class Solution309{
    static ArrayList<ArrayList<Integer>> Print(TreeNode1 pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return result;
        }
        Queue<TreeNode1> layer = new LinkedList<TreeNode1>();
        ArrayList<Integer> layerList = new ArrayList<Integer>();
        layer.add(pRoot);
        int start = 0, end = 1;
        while(!layer.isEmpty()){
            TreeNode1 cur = layer.remove();
            layerList.add(cur.val);
            start++;
            if(cur.left!=null){
                layer.add(cur.left);
            }
            if(cur.right!=null){
                layer.add(cur.right);
            }
            if(start == end){
                end = layer.size();
                start = 0;
                result.add(layerList);
                layerList = new ArrayList<Integer>();
            }
        }
        return result;
    }

}*/
