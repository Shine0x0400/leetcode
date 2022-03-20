package com.zjl.leetcode

import com.zjl.leetcode.datastructure.ListNode

/**
 *
 *
 * @author zjl
 * @date  2022/3/26
 */
class Leet206_reverseList {

    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        var ans = head
        var p = head.next
        head.next = null
        while (p != null) {
            val tmp = p.next
            p.next = ans
            ans = p
            p = tmp
        }
        return ans
    }
}