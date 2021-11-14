package com.zjl.jian_zhi_offer

import com.zjl.leetcode.datastructure.ListNode

class JZ06_ReversePrint {
    fun reversePrint(head: ListNode?): IntArray {
        var reversed: ListNode? = null
        var p = head
        var size = 0
        while (p != null) {
            size++
            val n = p.next
            p.next = reversed
            reversed = p
            p = n
        }

        val array = IntArray(size)
        for (i in 0 until size) {
            array[i] = reversed!!.`val`
            reversed = reversed.next
        }

        return array
    }
}