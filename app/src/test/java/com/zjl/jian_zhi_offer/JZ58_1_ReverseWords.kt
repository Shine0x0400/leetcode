package com.zjl.jian_zhi_offer

import java.util.*

/**
 *
 *
 * @author zjl
 * @date  2022/3/10
 */
class JZ58_1_ReverseWords {
    fun reverseWords(s: String): String {
        val builder = StringBuilder()
        val stack = LinkedList<Char>()
        for (i in s.lastIndex downTo 0) {
            if (s[i] != ' ') {
                stack.push(s[i])
                continue
            }
            if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    builder.append(stack.pop())
                }
                builder.append(' ')
            }
        }

        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                builder.append(stack.pop())
            }
            builder.append(' ')
        }

        if (builder.isNotEmpty()) {
            builder.deleteCharAt(builder.lastIndex)
        }

        return builder.toString()
    }
}