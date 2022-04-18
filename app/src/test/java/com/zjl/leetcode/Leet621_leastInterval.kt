package com.zjl.leetcode

import java.util.*

/**
 *
 *
 * @author zjl
 * @date  2022/4/21
 */
class Leet621_leastInterval {

    fun leastInterval(tasks: CharArray, n: Int): Int {
        if (n == 0) {
            return tasks.size
        }

        val counts = hashMapOf<Char, Int>()
        tasks.forEach {
            counts[it] = counts.getOrDefault(it, 0) + 1
        }

        // 大顶堆
        val heap = PriorityQueue<Char>(object : Comparator<Char> {
            override fun compare(o1: Char?, o2: Char?): Int {
                return counts[o2]!! - counts[o1]!!
            }
        })
        counts.keys.forEach {
            heap.add(it)
        }

        var ans = 0

        // 记录各个任务所在组内的位置
        val position = IntArray(26) {
            -1
        }
        var pos = 0

        // every n+1 as a group
        while (heap.isNotEmpty()) {
            val t = kotlin.math.min(heap.size, n + 1)
            val addBack = arrayListOf<Char>()
            for (i in 1..t) {
                val c = heap.poll()!!
                val h = c - 'A'
                if (position[h] == -1) {
                    position[h] = pos++
                }

                counts[c] = counts[c]!! - 1
                if (counts[c] == 0) {
                    pos--
                    counts.remove(c)
                } else {
                    addBack.add(c)
                }
            }

            heap.addAll(addBack)

            ans += if (heap.isNotEmpty()) (n + 1) else t
        }

        return ans
    }
}