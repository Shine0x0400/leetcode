package com.zjl.leetcode;

import com.zjl.leetcode.datastructure.ListNode;

/**
 * @author zjl
 * @date 2019-06-23
 */
public class Leet23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        // using divide-and-conquer
        return mergeKListsInternal(lists, 0, lists.length - 1);
    }

    // using divide-and-conquer
    // T(n) = 2 * T(n/2) + min(left.length, right.length)
    private ListNode mergeKListsInternal(ListNode[] lists, int start, int end) {

        if (start == end) {
            return lists[start];
        } else if (start > end) {
            return null;
        }

        int mid = (start + end) >> 1;

        ListNode left = mergeKListsInternal(lists, start, mid);
        ListNode right = mergeKListsInternal(lists, mid + 1, end);

        ListNode merge = null, cur = null;

        while (left != null && right != null) {
            if (left.val < right.val) {
                if (cur == null) {
                    merge = cur = left;
                } else {
                    cur.next = left;
                    cur = cur.next;
                }

                left = left.next;
            } else {
                if (cur == null) {
                    merge = cur = right;
                } else {
                    cur.next = right;
                    cur = cur.next;
                }

                right = right.next;
            }
        }

        if (left != null) {
            if (cur == null) {
                merge = left;
            } else {
                cur.next = left;
            }
        }

        if (right != null) {
            if (cur == null) {
                merge = right;
            } else {
                cur.next = right;
            }
        }

        return merge;
    }


//    // using PriorityQueue
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length == 0) {
//            return null;
//        } else if (lists.length == 1) {
//            return lists[0];
//        }
//
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val - o2.val;
//            }
//        });
//
//        for (ListNode node :
//                lists) {
//            if (node != null) {
//                queue.add(node);
//            }
//        }
//
//        ListNode head = new ListNode(0), tail = head;
//        while (!queue.isEmpty()) {
//            ListNode node = queue.poll();
//            tail.next = node;
//            tail = tail.next;
//
//            if (node.next != null) {
//                queue.add(node.next);
//            }
//        }
//
//        return head.next;
//
//    }
}
