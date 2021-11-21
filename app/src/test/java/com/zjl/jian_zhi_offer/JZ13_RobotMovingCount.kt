package com.zjl.jian_zhi_offer

class JZ13_RobotMovingCount {
    private var count = 0
    fun movingCount(m: Int, n: Int, k: Int): Int {
        val matrix = Array(m) { IntArray(n) }
        dfs(matrix, 0, 0, k)
        return count
    }

    private fun dfs(matrix: Array<IntArray>, x: Int, y: Int, k: Int) {
        if (x < 0 || x >= matrix.size || y < 0 || y >= matrix[0].size

            || matrix[x][y] == 1
            || !isQualified(x, y, k)
        ) {
            return
        }

        count++
        matrix[x][y] = 1

        dfs(matrix, x + 1, y, k)
        dfs(matrix, x - 1, y, k)
        dfs(matrix, x, y + 1, k)
        dfs(matrix, x, y - 1, k)
    }

    private fun isQualified(x: Int, y: Int, k: Int): Boolean {
        return x / 10 + x % 10 + y / 10 + y % 10 <= k
    }
}