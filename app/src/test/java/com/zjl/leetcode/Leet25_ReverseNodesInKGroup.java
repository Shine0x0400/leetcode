package com.zjl.leetcode;

import com.zjl.leetcode.datastructure.ListNode;

/**
 * @author zjl
 * @date 2019-07-25
 */
public class Leet25_ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ansHead = new ListNode(0);
        ListNode ansTail = ansHead;

        while (head != null) {
            ListNode group = head;
            int count = 1;
            while (head.next != null && count < k) {
                head = head.next;
                count++;
            }

            ListNode nextLoop = head.next;
            head.next = null; // split short group
            head = nextLoop;


            if (count == k) {
                ListNode p = group;
                while (p != null) {
                    ListNode tmp = p.next;
                    p.next = ansTail.next;
                    ansTail.next = p;
                    p = tmp;
                }
                ansTail = group;

            } else { // at the end
                ansTail.next = group;
            }
        }

        return ansHead.next;
    }
}
