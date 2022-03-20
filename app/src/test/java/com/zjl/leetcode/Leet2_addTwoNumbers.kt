package com.zjl.leetcode

import com.zjl.leetcode.datastructure.ListNode

/**
 *
 *
 * @author zjl
 * @date  2022/3/22
 */
class Leet2_addTwoNumbers {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var head: ListNode? = null
        var tail: ListNode? = null
        var p1 = l1
        var p2 = l2
        var carry = 0
        while (p1 != null || p2 != null) {
            val sum = (p1?.`val` ?: 0) + (p2?.`val` ?: 0) + carry
            carry = sum / 10
            val n = ListNode(sum % 10)
            if (tail == null) {
                head = n
                tail = head
            } else {
                tail.next = n
                tail = tail.next
            }
            p1 = p1?.next
            p2 = p2?.next
        }
        if (carry > 0) {
            tail!!.next = ListNode(carry)
        }
        return head
    }

//    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
//        if (l1 == null) {
//            return l2
//        }
//        if (l2 == null) {
//            return l1
//        }
//
//        var p1 = l1
//        var p2 = l2
//        var tail: ListNode = p1
//        var extra = 0
//
//        while (p1 != null && p2 != null) {
//            val sum = p1.`val` + p2.`val` + extra
//            if (sum < 10) {
//                p1.`val` = sum
//                extra = 0
//            } else {
//                p1.`val` = sum - 10
//                extra = 1
//            }
//            tail = p1
//
//            p1 = p1.next
//            p2 = p2.next
//        }
//
//        if (p2 != null) {
//            p1 = p2
//            tail.next = p2
//        }
//
//        while (p1 != null) {
//            val sum = p1.`val` + extra
//            if (sum < 10) {
//                p1.`val` = sum
//                extra = 0
//            } else {
//                p1.`val` = sum - 10
//                extra = 1
//            }
//            tail = p1
//            p1 = p1.next
//        }
//
//        if (extra == 1) {
//            tail.next = ListNode(1)
//        }
//
//        return l1
//    }
}