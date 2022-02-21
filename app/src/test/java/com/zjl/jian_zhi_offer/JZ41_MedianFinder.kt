package com.zjl.jian_zhi_offer

import java.util.*

/**
 *
 *
 * @author dylannzhang
 * @date 2022/2/21
 */
class JZ41_MedianFinder {
    // 约定总个数是奇数时，small多放一个
    val small = PriorityQueue<Int> { o1, o2 -> o2 - o1 } // 大顶堆
    val big = PriorityQueue<Int>() // 小顶堆

    fun addNum(num: Int) {
        if (small.size == big.size) {
            big.add(num)
            small.add(big.poll())
        } else {
            small.add(num)
            big.add(small.poll())
        }
    }

    fun findMedian(): Double {
        if (small.size == 0) {
            return 0.0
        }

        return if (small.size != big.size) {
            small.peek().toDouble()
        } else {
            (small.peek() + big.peek()) / 2.0
        }
    }
}