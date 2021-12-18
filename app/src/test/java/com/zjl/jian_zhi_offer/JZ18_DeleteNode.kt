package com.zjl.jian_zhi_offer

import com.zjl.leetcode.datastructure.ListNode

class JZ18_DeleteNode {
    fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) {
            return head
        }

        if (head.`val` == `val`) {
            return head.next
        }

        var pre = head
        while (pre!!.next != null) {
            if (pre.next.`val` == `val`) {
                pre.next = pre.next.next
                break
            }
            pre = pre.next
        }

        return head
    }
}