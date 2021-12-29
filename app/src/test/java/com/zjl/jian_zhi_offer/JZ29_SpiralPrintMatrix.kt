package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author zjl
 * @date  2021/12/26
 */
class JZ29_SpiralPrintMatrix {
    fun spiralOrder(matrix: Array<IntArray>): IntArray {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return IntArray(0)
        }

        val result = IntArray(matrix.size * matrix[0].size)

        var l = 0
        var t = 0
        var r = matrix[0].size - 1
        var b = matrix.size - 1

        var p = 0
        while (l <= r && t <= b) {
            for (i in l..r) {
                result[p++] = matrix[t][i]
            }
            t++
            if (t > b) {
                break
            }

            for (i in t..b) {
                result[p++] = matrix[i][r]
            }
            r--
            if (l > r) {
                break
            }

            for (i in r downTo l) {
                result[p++] = matrix[b][i]
            }
            b--
            if (t > b) {
                break
            }

            for (i in b downTo t) {
                result[p++] = matrix[i][l]
            }
            l++
        }

        return result
    }
}