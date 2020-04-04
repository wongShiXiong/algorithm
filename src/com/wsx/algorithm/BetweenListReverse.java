package com.wsx.algorithm;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 */
public class BetweenListReverse {
    public static void main(String[] args) {

    }
}
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        /*
        思路分析：1.m为逆序前逆序段的首节点，n为逆序前逆序段的尾节点
        2.故需要记录逆序段 首节点前的节点地址和尾节点之后节点地址
            2.1首节点前地的节点为m-1
            2.2改变的逆序段的长度为n-m+1
            2.3尾节点之后的节点为n+1
        3.记录之后中间进行逆序（ListReverse已做过）
        4.然后还有两种情况
            4.1需要判断出是否m=1，如果等于一需要进行处理
         */
        //需要逆序的链表长度
        int change_line = n - m + 1;
        //初始化逆序链表钱去节点
        ListNode pre_head = null;
        //指定逆序链表后的头节点，没有m=1则为head
        //head是移动完的头，目前在逆序区尾部
        ListNode result = head;

        //将逆序后的头节点移动到m处，也就是移动m-1个位置
        while(head!=null && --m>0){
            pre_head = head;
            head = head.next;
        }


        ListNode modify_list_tail = head;

        ListNode new_head = null;

        while(head!=null && change_line-->0){

        }






        return null;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution1 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode root = head;
        ListNode pre_head = null;
        int len = n-m+1;
        while(head!=null && --m>0){
            pre_head = head;
            head = head.next;
        }
        ListNode tail = head;
        ListNode new_head = null;

        while(head!=null && len-->0){
            ListNode next = head.next;
            head.next = new_head;
            new_head = head;
            head = next;
        }
        tail.next = head;
        if(pre_head!=null){
            pre_head.next = new_head;
        }else{
            return new_head;
        }

        return root;
    }
}