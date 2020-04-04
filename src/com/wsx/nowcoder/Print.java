package com.wsx.nowcoder;

import java.util.ArrayList;
import java.util.Stack;

public class Print {
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

        final ArrayList<ArrayList<Integer>> print = Solution308.Print(root);
    }
    }

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
class Solution308 {
    public static ArrayList<ArrayList<Integer> > Print(TreeNode1 pRoot) {
        int layer = 1;
        Stack<TreeNode1> s1 = new Stack();
        s1.push(pRoot);
        Stack<TreeNode1> s2 = new Stack();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        while(!s1.empty() || !s2.empty()){
            if(layer % 2 != 0){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while(!s1.isEmpty()){
                    TreeNode1 node = s1.pop();
                    if(node != null){
                        temp.add(node.val);
                        System.out.print(node.val+" ");
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if(!temp.isEmpty()){
                    list.add(temp);

                    layer++;
                    System.out.println();
                }
            }else{
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while(!s2.isEmpty()){
                    TreeNode1 node = s2.pop();
                    if(node != null){
                        temp.add(node.val);
                        System.out.print(node.val+" ");
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if(!temp.isEmpty()){
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            }
        }
        return list;
    }




/*    public static ArrayList<ArrayList<Integer>> Print2(TreeNode1 pRoot) {
        int layer = 1;
        //s1存奇数层节点
        Stack<TreeNode1> s1 = new Stack<TreeNode1>();
        s1.push(pRoot);
        //s2存偶数层节点
        Stack<TreeNode1> s2 = new Stack<TreeNode1>();

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        while (!s1.empty() || !s2.empty()) {
            if (layer%2 != 0) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s1.empty()) {
                    TreeNode1 node = s1.pop();
                    if(node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            } else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s2.empty()) {
                    TreeNode1 node = s2.pop();
                    if(node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            }
        }
        return list;
    }*/
}


















