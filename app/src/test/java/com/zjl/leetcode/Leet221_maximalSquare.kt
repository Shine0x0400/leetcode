package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/3/27
 */
class Leet221_maximalSquare {

    /**
     * 动态规划
     */
    fun maximalSquareDP(matrix: Array<CharArray>): Int {
        // dp[i][j], 表示以(i, j)为右下角可成正方形的最大边长
        val dp = Array<IntArray>(matrix.size) {
            IntArray(matrix[0].size)
        }

        var maxEdge = 0
        matrix.forEachIndexed { i, chars ->
            chars.forEachIndexed { j, c ->
                if (c == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1
                    } else {
                        dp[i][j] = 1 + dp[i - 1][j].coerceAtMost(dp[i][j - 1]).coerceAtMost(dp[i - 1][j - 1])
                    }
                    maxEdge = maxEdge.coerceAtLeast(dp[i][j])
                }
            }
        }
        return maxEdge * maxEdge
    }

    fun maximalSquare(matrix: Array<CharArray>): Int {
        // 记录各个位置左侧连续1的个数
        val leftContinuous = Array<IntArray>(matrix.size) {
            IntArray(matrix[0].size)
        }

        for (i in 0..matrix.lastIndex) {
            for (j in 0..matrix[0].lastIndex) {
                leftContinuous[i][j] = if (matrix[i][j] == '0') 0 else (1 + if (j == 0) 0 else leftContinuous[i][j - 1])
            }
        }

        var ans = 0
        // 以各个位置作为矩形右下角来遍历
        for (i in 0..matrix.lastIndex) {
            for (j in 0..matrix[0].lastIndex) {
                var minWidth = leftContinuous[i][j]
                for (k in i downTo 0) {
                    minWidth = minWidth.coerceAtMost(leftContinuous[k][j])
                    val height = i - k + 1
                    if (minWidth < height) {
                        break
                    }
                    ans = ans.coerceAtLeast(height * height)
                }
            }
        }

        return ans
    }
}