package com.zjl.jian_zhi_offer

import java.util.*

class JZ09_ImplementQueueWithTwoStacks {
    private val appendStack = LinkedList<Int>()
    private val deleteStack = LinkedList<Int>()

    fun appendTail(value: Int) {
        appendStack.push(value)
    }

    fun deleteHead(): Int {
        if (!deleteStack.isEmpty()) {
            return deleteStack.pop()
        }

        if (!appendStack.isEmpty()) {
            while (!appendStack.isEmpty()) {
                deleteStack.push(appendStack.pop())
            }
            return deleteStack.pop()
        }

        return -1
    }
}