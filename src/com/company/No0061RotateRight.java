package com.company;

public class No0061RotateRight {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = rotateRight(head, 2);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode cur = head;
        int size = 1;
        while (cur.next != null){
            cur = cur.next;
            size ++;
        }
        // 构建一个循环链表
        cur.next = head;
        int rightNum = size - k % size;
        while (rightNum>0){
            head = head.next;
            cur = cur.next;
            rightNum--;
        }
        cur.next = null;

        return head;
    }
}
