package com.zjl.jian_zhi_offer

import java.util.*

/**
 *
 *
 * @author zjl
 * @date  2021/12/29
 */
class JZ31_ValidateStackSequences {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val stack = Stack<Int>()
        var i = 0
        var j = 0

        while (j < popped.size) {
            if (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop()
                j++
            } else {
                if (i < pushed.size) {
                    stack.push(pushed[i++])
                } else {
                    break
                }
            }
        }

        return stack.isEmpty()
    }
}