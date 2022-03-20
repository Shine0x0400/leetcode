package com.zjl.leetcode

import java.util.*

/**
 *
 *
 * @author zjl
 * @date  2022/3/20
 */
class Leet85_maximalRectangle {

    // https://leetcode-cn.com/problems/maximal-rectangle/solution/zui-da-ju-xing-by-leetcode-solution-bjlu/
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        // left[i][j]记录matrix[i][j]左侧连续1的个数
        val left = Array<IntArray>(matrix.size) {
            IntArray(matrix[0].size)
        }
        matrix.forEachIndexed { i, chars ->
            chars.forEachIndexed { j, c ->
                left[i][j] = if (c == '0') 0 else (1 + if (j > 0) left[i][j - 1] else 0)
            }
        }

        var area = 0
        matrix.forEachIndexed { i, chars ->
            chars.forEachIndexed { j, c ->
                // 计算以(i, j)为右下角的最大矩形面积, 不断增加高度
                var minWidth = left[i][j]
                for (k in i downTo 0) {
                    minWidth = minWidth.coerceAtMost(left[k][j])
                    if (minWidth == 0) {
                        break
                    }

                    area = area.coerceAtLeast(minWidth * (i - k + 1))
                }
            }
        }

        return area
    }

    // 单调栈
    fun maximalRectangleWithMonotonicStack(matrix: Array<CharArray>): Int {
        // left[i][j]记录matrix[i][j]左侧连续1的个数
        val left = Array<IntArray>(matrix.size) {
            IntArray(matrix[0].size)
        }
        matrix.forEachIndexed { i, chars ->
            chars.forEachIndexed { j, c ->
                left[i][j] = if (c == '0') 0 else (1 + if (j > 0) left[i][j - 1] else 0)
            }
        }

        val top = IntArray(matrix.size)
        val bottom = IntArray(matrix.size)
        val stack = LinkedList<Int>()
        var ans = 0

        for (j in 0..matrix[0].lastIndex) {
            stack.clear()
            // 计算以 left[i][j]为宽度的矩形的上边
            for (i in 0..matrix.lastIndex) {
                while (stack.isNotEmpty() && left[stack.peek()!!][j] >= left[i][j]) {
                    stack.pop()
                }
                top[i] = if (stack.isEmpty()) -1 else stack.peek()!!
                stack.push(i)
            }

            stack.clear()
            // 计算以 left[i][j]为宽度的矩形的下边
            for (i in matrix.lastIndex downTo 0) {
                while (stack.isNotEmpty() && left[stack.peek()!!][j] >= left[i][j]) {
                    stack.pop()
                }
                bottom[i] = if (stack.isEmpty()) matrix.size else stack.peek()!!
                stack.push(i)
            }

            // 分别计算以 left[i][j]为宽度的矩形的面积
            for (i in 0..matrix.lastIndex) {
                ans = ans.coerceAtLeast(left[i][j] * (bottom[i] - top[i] - 1))
            }
        }

        return ans
    }
}