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
class ListNode1{
    int val;
    ListNode next;
    ListNode1(int x) { val = x; }
}
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        /*
        思路分析：m为逆序前逆序段的首节点
         */
        int change_line = n - m + 1;
    }
}