package com.zjl.jian_zhi_offer;

import com.zjl.leetcode.datastructure.ListNode;

/**
 * @author dylannzhang
 * @date 2022/3/2
 */
class JZ52_FirstIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        boolean swapA = false;
        boolean swapB = false;

        while (a != null && b != null) {
            if (a == b) {
                return a;
            }

            a = a.next;
            b = b.next;

            if (a == null && !swapA) {
                a = headB;
                swapA = true;
            }

            if (b == null && !swapB) {
                b = headA;
                swapB = true;
            }
        }

        return null;
    }
}
