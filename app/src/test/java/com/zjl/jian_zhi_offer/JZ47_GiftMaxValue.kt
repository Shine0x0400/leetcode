package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author dylannzhang
 * @date 2022/2/28
 */
class JZ47_GiftMaxValue {
    fun maxValue(grid: Array<IntArray>): Int {
        val v = Array<IntArray>(grid.size) {
            IntArray(grid[0].size)
        }

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                v[i][j] = grid[i][j] + Math.max(if (i > 0) v[i - 1][j] else 0, if (j > 0) v[i][j - 1] else 0)
            }
        }

        return v[v.lastIndex][v[0].lastIndex]
    }

//    /**
//     * recursive will exceed time
//     */
//    fun maxValue(grid: Array<IntArray>): Int {
//        return recursive(grid, grid.lastIndex, grid[0].lastIndex)
//    }
//
//    private fun recursive(grid: Array<IntArray>, x: Int, y: Int): Int {
//        return grid[x][y] + Math.max(if (x > 0) recursive(grid, x - 1, y) else 0, if (y > 0) recursive(grid, x, y - 1) else 0)
//    }
}