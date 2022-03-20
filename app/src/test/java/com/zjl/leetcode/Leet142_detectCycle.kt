package com.zjl.leetcode

import com.zjl.leetcode.datastructure.ListNode

/**
 *
 *
 * @author zjl
 * @date  2022/3/25
 */
class Leet142_detectCycle {
    fun detectCycle(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        while (fast?.next?.next != null) {
            slow = slow?.next
            fast = fast.next.next

            // encounter
            if (slow == fast) {
                var p = head
                while (p != slow) {
                    p = p?.next
                    slow = slow?.next
                }
                return p
            }
        }
        return null
    }
}