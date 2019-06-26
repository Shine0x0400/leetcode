package com.zjl.leetcode;

import com.zjl.leetcode.datastructure.ListNode;

/**
 * @author zjl
 * @date 2019-06-27
 */
public class Leet19_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode tail = head, pre = null;
        int distance = 0;

        while (tail.next != null) {
            tail = tail.next;
            distance++;

            if (distance == n) {
                pre = head;
            } else if (distance > n) {
                pre = pre.next;
            }
        }

        if (pre == null) {
            head = head.next;
        } else {
            pre.next = pre.next.next;
        }

        return head;
    }
}
