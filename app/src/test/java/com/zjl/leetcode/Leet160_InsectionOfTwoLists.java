package com.zjl.leetcode;

/**
 * 双指针方案
 *
 * @author zjl
 * @date 2019-06-18
 */
public class Leet160_InsectionOfTwoLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pa = headA, pb = headB;
        boolean swapA = false, swapB = false;

        while (pa != null && pb != null) {
            if (pa == pb) {
                return pa;
            }

            pa = pa.next;
            pb = pb.next;

            if (pa == null && !swapA) {
                pa = headB;
                swapA = true;
            }

            if (pb == null && !swapB) {
                pb = headA;
                swapB = true;
            }
        }

        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
