package com.wsx.nowcoder;

import com.wsx.ListNode;

public class DeleteDuplication {
}
class Solution305 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode temp = new ListNode(0);
        temp.next = pHead;
        ListNode pre = temp;
        ListNode last = temp.next;
        while(last != null){
            if(last.next != null && last.val == last.next.val){
                while(last.next != null && last.val==last.next.val){
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            }else{
                pre = pre.next;
                last = last.next;
            }
        }
        return temp.next;
    }
}