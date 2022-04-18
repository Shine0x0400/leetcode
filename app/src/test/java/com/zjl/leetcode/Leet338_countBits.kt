package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/13
 */
class Leet338_countBits {

    fun countBits(n: Int): IntArray {
        val ans = IntArray(n + 1)
        ans[0] = 0
        var p = 1
        for (i in 1..n) {
            if (i == 1) {
                ans[i] = 1
                continue
            }
            if (i == p shl 1) {
                ans[i] = 1
                p = p shl 1
            } else {
                ans[i] = 1 + ans[i - p]
            }
        }
        return ans
    }
}