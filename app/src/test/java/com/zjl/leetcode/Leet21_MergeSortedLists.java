package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-18
 */
public class Leet21_MergeSortedLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, t = null;

        int tv;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tv = l1.val;
                l1 = l1.next;
            } else {
                tv = l2.val;
                l2 = l2.next;
            }

            if (t != null) {
                t.next = new ListNode(tv);
                t = t.next;
            } else {
                head = t = new ListNode(tv);
            }
        }

        while (l1 != null) {
            if (t != null) {
                t.next = new ListNode(l1.val);
                t = t.next;
            } else {
                head = t = new ListNode(l1.val);
            }

            l1 = l1.next;
        }

        while (l2 != null) {
            if (t != null) {
                t.next = new ListNode(l2.val);
                t = t.next;
            } else {
                head = t = new ListNode(l2.val);
            }

            l2 = l2.next;
        }

        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
