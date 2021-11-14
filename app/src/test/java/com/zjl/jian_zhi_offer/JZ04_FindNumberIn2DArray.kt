package com.zjl.jian_zhi_offer

class JZ04_FindNumberIn2DArray {
    // 从右上角和左下角找起都可以，题解是从右上找起的，这里我从左下找起
    fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return false
        }

        var r = matrix.size - 1
        var c = 0

        while (r >= 0 && c < matrix[0].size) {
            val i = matrix[r][c]
            when {
                i == target -> {
                    return true
                }
                i < target -> {
                    c++
                }
                else -> {
                    r--
                }
            }
        }

        return false
    }
}