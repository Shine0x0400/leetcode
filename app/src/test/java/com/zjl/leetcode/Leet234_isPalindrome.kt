package com.zjl.leetcode

import com.zjl.leetcode.datastructure.ListNode

/**
 *
 *
 * @author zjl
 * @date  2022/3/30
 */
class Leet234_isPalindrome {

    fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) {
            return true
        }
        var slow = head
        var fast = head
        var tail: ListNode? = null

        while (fast?.next?.next != null) {
            fast = fast.next.next
            // 反转链表
            val next = slow!!.next
            slow.next = tail
            tail = slow
            slow = next
        }

        var ans = true
        var forward = slow!!.next
        var back = tail
        if (fast?.next == null) { // 奇数个节点

        } else {// 偶数个
            if (slow.`val` != forward.`val`) {
                ans = false
            }
            forward = forward.next
        }

        tail = slow
        while (forward != null) {
            if (forward.`val` != back!!.`val`) {
                ans = false
            }
            forward = forward.next

            // 恢复链表
            val previous = back.next
            back.next = tail
            tail = back
            back = previous
        }

        return ans
    }
}