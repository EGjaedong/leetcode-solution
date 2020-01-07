package com.company;

public class No0002TwoNumAdd{
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(5);

        ListNode head = addTwoNumbers(l1, l2);
        printList(head);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        int flag = 0;
        int sum = l1.val + l2.val;
        l1 = l1.next;
        l2 = l2.next;
        if(sum >= 10){
            sum = sum % 10;
            flag = 1;
        }

        ListNode head = new ListNode(sum);
        ListNode cur = head;
        while(l1 != null && l2 != null){
            sum = l1.val + l2.val + flag;
            flag = sum >= 10? 1:0;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        // 退出循环，说明有一个完了，把剩下的挂接上去
        if(l1 == null){
            while(l2 != null){
                sum = l2.val + flag;
                flag = sum >= 10? 1:0;
                sum = sum % 10;
                if(flag == 0){
                    cur.next = new ListNode(sum);
                    cur.next.next = l2.next;
                    break;
                }
                else{
                    cur.next = new ListNode(sum);
                    cur = cur.next;
                    l2 = l2.next;
                }
            }
        }
        if(l2 == null){
            while(l1 != null){
                sum = l1.val + flag;
                flag = sum >= 10? 1:0;
                sum = sum % 10;
                if(flag == 0){
                    cur.next = new ListNode(sum);
                    cur.next.next = l1.next;
                    break;
                }
                else{
                    cur.next = new ListNode(sum);
                    cur = cur.next;
                    l1 = l1.next;
                }
            }
        }

        if (flag == 1){
            cur.next = new ListNode(1);
        }

        return head;
    }

    public static void printList(ListNode l){
        while(l != null){
            System.out.print(l.val + "->");
            l = l.next;
        }
    }
}