package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-18
 */
public class Leet141_LinkedListCircle {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head.next, slow = head;

        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }

            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = null;
            }
        }

        return false;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
