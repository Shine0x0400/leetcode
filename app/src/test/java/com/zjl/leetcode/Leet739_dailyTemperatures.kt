package com.zjl.leetcode

import java.util.*

/**
 *
 *
 * @author zjl
 * @date  2022/4/22
 */
class Leet739_dailyTemperatures {

    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val ans = IntArray(temperatures.size)
        val increaseQueue = LinkedList<Pair<Int, Int>>()

        for (i in temperatures.lastIndex downTo 0) {
            val t = temperatures[i]
            while (increaseQueue.isNotEmpty()) {
                if (increaseQueue.first.first <= t) {
                    increaseQueue.removeFirst()
                } else {
                    ans[i] = increaseQueue.first.second - i
                    break
                }
            }
            increaseQueue.addFirst(Pair(t, i))
        }

        return ans
    }
}