package com.zjl.leetcode;

import com.zjl.leetcode.datastructure.ListNode;

/**
 * @author zjl
 * @date 2019-06-27
 */
public class Leet24_SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        ListNode addHead = new ListNode(0);
        addHead.next = head;

        ListNode i = addHead;

        while (i.next != null && i.next.next != null) {
            // swap i.next and i.next.next

            ListNode temp = i.next.next;
            i.next.next = temp.next;
            temp.next = i.next;
            i.next = temp;

            i = i.next.next;
        }

        return addHead.next;
    }
}
