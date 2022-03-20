package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/2
 */
class Leet240_searchMatrix {

    // Time Complex: O(m+n)
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        // from top-right corner
        var r = 0
        var c = matrix[0].lastIndex
        var ans = false
        while (r < matrix.size && c >= 0) {
            val v = matrix[r][c]
            if (v == target) {
                ans = true
                break
            } else if (v < target) {
                r++
            } else {
                c--
            }
        }
        return ans
    }
}