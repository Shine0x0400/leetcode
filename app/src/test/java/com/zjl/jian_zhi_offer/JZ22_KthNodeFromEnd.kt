package com.zjl.jian_zhi_offer

import com.zjl.leetcode.datastructure.ListNode

class JZ22_KthNodeFromEnd {
    fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
        var p = head
        for (i in 1 until k) {
            p = p?.next ?: return null
        }

        var r: ListNode? = head
        while (p?.next != null) {
            p = p.next
            r = r?.next
        }

        return r
    }
}