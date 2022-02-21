package com.zjl.jian_zhi_offer

import java.util.*

/**
 *
 *
 * @author dylannzhang
 * @date 2022/2/21
 */
class JZ40_GetLeastK {
    fun getLeastNumbers(arr: IntArray, k: Int): IntArray {
        if (k == 0) {
            return IntArray(k)
        }

        val q = PriorityQueue<Int> { o1, o2 -> o2 - o1 }
        arr.forEach {
            if (q.size < k) {
                q.add(it)
            } else {
                if (q.peek() > it) {
                    q.poll()
                    q.add(it)
                }
            }
        }

        return q.toIntArray()
    }
}