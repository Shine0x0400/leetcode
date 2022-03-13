package com.zjl.jian_zhi_offer

import java.util.*

/**
 *
 *
 * @author zjl
 * @date  2022/3/11
 */
class JZ59_2_MaxQueue {
    val data = LinkedList<Int>()
    val max = LinkedList<Int>()

    fun max_value(): Int {
        return if (max.isEmpty()) -1 else max.first
    }

    /**
     * 入队虽然有循环出队操作，但一个元素最多只会有一次出队，均摊到每个元素上，认为是O(1)的时间复杂度
     */
    fun push_back(value: Int) {
        while (max.isNotEmpty() && max.last <= value) {
            max.removeLast()
        }

        max.offer(value)
        data.offer(value)
    }

    fun pop_front(): Int {
        if (data.isEmpty()) {
            return -1
        }

        val ans = data.poll()!!
        if (max.first == ans) {
            max.removeFirst()
        }
        return ans
    }
}