package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/3/19
 */
class Leet72_ConvertWordMinOperations {

    /**
     * dynamic programming
     */
    fun minDistance(word1: String, word2: String): Int {
        val dp = Array<IntArray>(word1.length + 1) {
            IntArray(word2.length + 1)
        }
        for (i in word1.length downTo 0) {
            for (j in word2.length downTo 0) {
                if (i == word1.length && j == word2.length) {
                    dp[i][j] = 0
                    continue
                }
                if (i == word1.length) {
                    dp[i][j] = word2.length - j
                    continue
                }
                if (j == word2.length) {
                    dp[i][j] = word1.length - i
                    continue
                }

                if (word1[i] == word2[j]) {
                    dp[i][j] = dp[i + 1][j + 1]
                    continue
                }

                val insert = dp[i][j + 1]
                val delete = dp[i + 1][j]
                val replace = dp[i + 1][j + 1]
                dp[i][j] = 1 + insert.coerceAtMost(delete).coerceAtMost(replace)
            }
        }
        return dp[0][0]
    }

//    /**
//     * recursive
//     */
//    fun minDistance(word1: String, word2: String): Int {
//        return recursive(word1, word2, 0, 0)
//    }
//
//    private fun recursive(word1: String, word2: String, i1: Int, i2: Int): Int {
//        if (i1 == word1.length && i2 == word2.length) {
//            return 0
//        }
//        if (i1 == word1.length) {
//            // need insert
//            return word2.length - i2
//        }
//        if (i2 == word2.length) {
//            // need delete
//            return word1.length - i1
//        }
//
//        if (word1[i1] == word2[i2]) {
//            return recursive(word1, word2, i1 + 1, i2 + 1)
//        }
//
//        // insert
//        val c1 = 1 + recursive(word1, word2, i1, i2 + 1)
//        if (c1 == 1) {
//            return 1
//        }
//        // delete
//        val c2 = 1 + recursive(word1, word2, i1 + 1, i2)
//        if (c2 == 1) {
//            return 1
//        }
//        // replace
//        val c3 = 1 + recursive(word1, word2, i1 + 1, i2 + 1)
//        if (c3 == 1) {
//            return 1
//        }
//        return c1.coerceAtMost(c2).coerceAtMost(c3)
//    }
}