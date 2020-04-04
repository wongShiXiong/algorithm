package com.wsx.nowcoder;

import com.wsx.TreeLinkNode;

public class GetNext {
    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(3);
        TreeLinkNode node3 = new TreeLinkNode(6);
        TreeLinkNode node4 = new TreeLinkNode(8);
        TreeLinkNode node5 = new TreeLinkNode(10);
        TreeLinkNode node6 = new TreeLinkNode(14);

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.left = node2;
        root.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;

        final Solution313 solution313 = new Solution313();
        final TreeLinkNode treeLinkNode = solution313.GetNext(root);
        System.out.println(treeLinkNode);
    }
}
/*
class Solution313 {
    TreeLinkNode GetNext(TreeLinkNode node)
    {
        if(node==null) return null;
        if(node.right!=null){    //如果有右子树，则找右子树的最左节点
            node = node.right;
            while(node.left!=null) node = node.left;
            return node;
        }
        while(node.next!=null){ //没右子树，则找第一个当前节点是父节点左孩子的节点
            if(node.next.left==node) return node.next;
            node = node.next;
        }
        return null;   //退到了根节点仍没找到，则返回null
    }
}*/
/*
class Solution313 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)
            return pNode;
        if (pNode.right != null) { // 节点有右子树
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else if ( pNode.next != null && pNode.next.left == pNode) { // 节点无右子树且该节点为父节点的左子节点
            return pNode.next;
        } else if (pNode.next != null && pNode.next .right == pNode) { // 节点无右子树且该节点为父节点的右子节点
            while(pNode.next != null && pNode .next .left != pNode){
                pNode = pNode.next ;
            }
            return pNode.next ;
        }else{
            return pNode.next ;//节点无父节点 ，即节点为根节点
        }
    }
}*/
class Solution313 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null){
            return pNode;
        }
        if(pNode.right != null){
            pNode = pNode.next;
            while(pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }else if(pNode.next != null && pNode.next.left == pNode){
            return pNode.left;
        }else if(pNode.next != null && pNode.next.right == pNode){
            while(pNode.next != null&& pNode.next.left != pNode){
                pNode = pNode.next;
            }
            return pNode.next;
        }else {
            return pNode.next;//==NULL
        }
    }
}