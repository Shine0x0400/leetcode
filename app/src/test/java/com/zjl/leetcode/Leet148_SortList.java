package com.zjl.leetcode;

import com.zjl.leetcode.datastructure.ListNode;

/**
 * @author zjl
 * @date 2019-07-13
 */
public class Leet148_SortList {

    public ListNode sortList(ListNode head) {

        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }

        int step = 1;
        while (step < length) {
            ListNode tmpList = new ListNode(0);
            ListNode tail = tmpList;

            while (head != null) {
                ListNode sub1 = head;
                head = spit(head, step);

                ListNode sub2 = head;
                head = spit(head, step);

                tail = merge(sub1, sub2, tail);
            }

            head = tmpList.next;
            step <<= 1;
        }

        return head;
    }

    /**
     * merge two list, tail point to the tail of the merged list.
     */
    private ListNode merge(ListNode sub1, ListNode sub2, ListNode tail) {
        while (sub1 != null && sub2 != null) {
            if (sub1.val < sub2.val) {
                tail.next = sub1;
                tail = tail.next;
                sub1 = sub1.next;
            } else {
                tail.next = sub2;
                tail = tail.next;
                sub2 = sub2.next;
            }
        }

        while (sub1 != null) {
            tail.next = sub1;
            tail = tail.next;
            sub1 = sub1.next;
        }

        while (sub2 != null) {
            tail.next = sub2;
            tail = tail.next;
            sub2 = sub2.next;
        }

        return tail;
    }

    /**
     * 撕下长度为length的头部链表，head指向剩余的链表
     */
    private ListNode spit(ListNode head, int length) {
        int subLength = 0;
        while (head != null && subLength < length) {
            subLength++;
            ListNode nextHead = head.next;
            if (subLength == length) {
                // break list
                head.next = null;
            }
            head = nextHead;
        }

        return head;
    }
}
