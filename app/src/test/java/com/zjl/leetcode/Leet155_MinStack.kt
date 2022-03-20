package com.zjl.leetcode

import java.util.*

/**
 *
 *
 * @author zjl
 * @date  2022/3/25
 */
class Leet155_MinStack {
    val dataStack = LinkedList<Int>()
    val minStack = LinkedList<Int>()

    fun push(`val`: Int) {
        if (minStack.isEmpty()) {
            minStack.push(`val`)
        } else {
            if (`val` <= minStack.peek()!!) {
                minStack.push(`val`)
            }
        }
        dataStack.push(`val`)
    }

    fun pop() {
        val p = dataStack.pop()
        if (p == minStack.peek()) {
            minStack.pop()
        }
    }

    fun top(): Int {
        return dataStack.peek()!!
    }

    fun getMin(): Int {
        return minStack.peek()!!
    }
}