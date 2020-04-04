package com.wsx.nowcoder;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Mirror {
    /**
     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }
     */
    public class Solution {
        public void Mirror(TreeNode1 root) {
            if(root == null){
                return;
            }
            if(root.left == null && root.right == null){
                return;
            }
            TreeNode1 p = root.left;
            root.left = root.right;
            root.right = p;//交换左右

            if(root.left != null){
                Mirror(root.left);//以新的左节点为根，开始递归左右子树
            }
            if(root.right != null){
                Mirror(root.right);
            }
        }
        public void test(){
            HashMap<Integer, String> map = new HashMap<>();
            ArrayList<String> strings = new ArrayList<>();
            LinkedList<String> strings1 = new LinkedList<>();
        }
    }















}
