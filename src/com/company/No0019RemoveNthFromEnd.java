package com.company;

import java.util.HashMap;

public class No0019RemoveNthFromEnd {
    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        int index = 1;
        ListNode cur = head;
        while (cur != null){
            map.put(index, cur);
            cur = cur.next;
            index++;
        }

        int removeIndex = map.size() - n + 1;
        if (removeIndex == 1){
            head = head.next;
        }
        else {
            ListNode pre = map.get(removeIndex - 1);
            pre.next = pre.next.next;
        }

        return head;
    }
}
