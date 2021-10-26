package com.zjl.leetcode

import kotlin.math.max

/**
 * @author zjl
 * @date  2021/10/26
 */

/**
 * use an extra array, iterator two times
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun candy(ratings: IntArray): Int {
    val candies = IntArray(ratings.size, init = { 1 })

    // left to right pass, only compare with the left neighbour
    for (i in 1 until ratings.size) {
        if (ratings[i] > ratings[i - 1]) {
            candies[i] = candies[i - 1] + 1
        }
    }

    var sum = candies[candies.lastIndex]

    // right to left pass, only compare with the right neighbour
    for (i in ratings.size - 2 downTo 0) {
        if (ratings[i] > ratings[i + 1]) {
            candies[i] = max(candies[i], candies[i + 1] + 1)
        }
        sum += candies[i]
    }

    return sum
}

fun candy2(ratings: IntArray): Int {
    // type of the old and the new slope
    var oldSlope = 0
    var newSlope = 0

    var upCnt = 0
    var downCnt = 0

    var result = 0
    for (i in 1 until ratings.size) {
        newSlope = if (ratings[i] > ratings[i - 1]) 1 else if (ratings[i] < ratings[i - 1]) -1 else 0

        if (newSlope == -1) {
            downCnt++
        } else if (newSlope == 1) {
            if (oldSlope == -1) {
                // 峰顶糖数应该是max(upCnt, downCnt)+1，这里没有加1，是因为谷底点被相邻山峰共有，我们约定这个点始终属于后一个山峰，而不能同时属于，不然就是重复加。
                result += (calculate(upCnt) + calculate(downCnt) + kotlin.math.max(upCnt, downCnt))

                upCnt = 0
                downCnt = 0
            }

            upCnt++
        } else { // 0
            if (oldSlope == 0) {
                result += 1
            } else {
                result += (calculate(upCnt) + calculate(downCnt) + kotlin.math.max(upCnt, downCnt) + 1)
            }

            upCnt = 0
            downCnt = 0
        }

        oldSlope = newSlope
    }

    result += (calculate(upCnt) + calculate(downCnt) + kotlin.math.max(upCnt, downCnt) + 1)
    return result
}

fun calculate(n: Int): Int {
    return n * (n + 1) / 2
}
