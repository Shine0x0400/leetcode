package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/22
 */
class Leet647_PalindromicSubstrings {

    fun countSubstrings(s: String): Int {
        // record whether substring [i, j] is a palindrome
        val dp = Array<BooleanArray>(s.length) {
            BooleanArray(s.length)
        }

        var ans = 0
        s.forEachIndexed { index, c ->
            for (j in index downTo 0) {
                dp[j][index] = (
                        j == index
                                || (s[j] == s[index] && (j + 1 == index || dp[j + 1][index - 1]))
                        ).also {
                        if (it) {
                            ans++
                        }
                    }
            }
        }
        return ans
    }

    /**
     * Manacher 算法
     */
    fun countSubstrings2(s: String): Int {
        val b = StringBuilder("$#")
        s.forEach {
            b.append(it).append("#")
        }
        val n = b.length
        b.append("!")
        // f[i]表示以b[i]为中心的最大回文半径长度
        val f = IntArray(n) {
            1
        }

        var ans = 0

        // 记录遍历过程中，回文的最右端
        var rMax = 0
        // 上述回文的中心
        var iMax = 0
        for (i in 2..n - 2) {
            if (i <= rMax) {
                f[i] = (rMax - i + 1).coerceAtMost(f[2 * iMax - i])
            }

            while (b[i + f[i]] == b[i - f[i]]) {
                f[i]++
            }

            if (i + f[i] - 1 > rMax) {
                rMax = i + f[i] - 1
                iMax = i
            }

            // 排除'#'的影响
            ans += (f[i] / 2)
        }
        return ans
    }
}