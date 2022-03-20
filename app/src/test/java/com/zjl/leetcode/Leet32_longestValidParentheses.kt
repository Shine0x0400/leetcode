package com.zjl.leetcode

import java.util.*

/**
 *
 *
 * @author zjl
 * @date  2022/3/19
 */
class Leet32_longestValidParentheses {
    // NOTE: "()(()"
    fun longestValidParentheses(s: String): Int {
        var ans = 0
        val stack = LinkedList<Int>()
        // dp[i]表示以s[i]结尾的有效长度
        val dp = IntArray(s.length)
        s.forEachIndexed { i, c ->
            if (c == '(') {
                stack.push(i)
            } else {
                if (stack.isNotEmpty()) {
                    val left = stack.pop()
                    dp[i] = (i - left + 1) + if (left > 0) dp[left - 1] else 0
                    ans = ans.coerceAtLeast(dp[i])
                }
            }
        }
        return ans
    }
}