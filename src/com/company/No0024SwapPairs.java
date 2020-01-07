package com.company;

public class No0024SwapPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        ListNode res = swapPairs(head);
        print(res);
    }

    public static void print(ListNode h){
        while (h != null){
            System.out.print(h.val + " ->");
            h = h.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;

        ListNode next = head.next;
        if (next == null)
            return head;

        ListNode cur = head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode dummyHead = pre;
        while (next != null){
            cur.next = next.next;
            next.next = cur;
            pre.next = next;
            pre = cur;
            cur = cur.next;
            if (cur == null)
                break;
            if (cur.next != null){
                next = cur.next;
            }else {
                next = null;
            }
        }
        return dummyHead.next;
    }
}
