package com.company;

public class No0021MergeTwoLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;


        ListNode head = l1.val <= l2.val? l1:l2;
        ListNode cur = head;
        if (l1.val <= l2.val) l1 = l1.next;
        else l2 = l2.next;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }

        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;

        return head;
    }
}
