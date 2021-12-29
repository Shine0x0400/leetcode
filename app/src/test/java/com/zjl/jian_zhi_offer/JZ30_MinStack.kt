package com.zjl.jian_zhi_offer

import java.util.*

/**
 *
 *
 * @author zjl
 * @date  2021/12/28
 */
class JZ30_MinStack {

    /** initialize your data structure here. */
    val data = Stack<Int>()
    val min = Stack<Int>()


    fun push(x: Int) {
        data.push(x)
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x)
        }
    }

    fun pop() {
        val pop = data.pop()
        if (pop == min.peek()) {
            min.pop()
        }
    }

    fun top(): Int {
        return data.peek()
    }

    fun min(): Int {
        return min.peek()
    }

}