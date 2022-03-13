package com.zjl.jian_zhi_offer

import java.util.*

/**
 *
 *
 * @author zjl
 * @date  2022/3/11
 */
class JZ59_1_maxSlidingWindow {

    // with 单调队列
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty()) {
            return IntArray(0)
        }
        val deque = LinkedList<Int>()
        for (i in 0 until k) {
            while (deque.isNotEmpty() && nums[deque.first] <= nums[i]) {
                deque.removeFirst()
            }
            deque.addFirst(i)
        }

        val ans = IntArray(nums.size - k + 1)
        ans[0] = nums[deque.last]

        for (i in k..nums.lastIndex) {
            while (deque.isNotEmpty() && nums[deque.first] <= nums[i]) {
                deque.removeFirst()
            }
            deque.addFirst(i)
            while (deque.isNotEmpty() && i - deque.last > k - 1) {
                deque.removeLast()
            }

            ans[i - k + 1] = nums[deque.last]
        }
        return ans
    }

    // use maxHeap
    fun maxSlidingWindowWithMaxHeap(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty()) {
            return IntArray(0)
        }
        // Pair(index, value)
        val maxHeap = PriorityQueue<Pair<Int, Int>>() { a, b ->
            b.second - a.second
        }
        for (i in 0 until k) {
            maxHeap.offer(Pair(i, nums[i]))
        }
        val ans = IntArray(nums.size - k + 1)
        var j = 0
        ans[j++] = maxHeap.peek()!!.second
        for (i in k..nums.lastIndex) {
            maxHeap.offer(Pair(i, nums[i]))

            while (!maxHeap.isEmpty() && i - maxHeap.peek()!!.first > k - 1) {
                maxHeap.poll()
            }

            ans[j++] = maxHeap.peek()!!.second
        }

        return ans
    }

    // 分块法, 将数组从0开始，每k个分成一块
    fun maxSlidingWindow3(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty()) {
            return IntArray(0)
        }
        val size = nums.size
        // prefixMax[i] 表示i所在分块，以i处结尾的前缀的最大值
        val prefixMax = IntArray(size)
        // suffixMax[i] 表示i所在分块，以i处开头的后缀的最大值
        val suffixMax = IntArray(size)
        for (i in 0 until size) {
            prefixMax[i] = if (i % k == 0) nums[i] else prefixMax[i - 1].coerceAtLeast(nums[i])
        }
        for (i in size - 1 downTo 0) {
            suffixMax[i] = if (i == size - 1 || (i + 1) % k == 0) nums[i] else suffixMax[i + 1].coerceAtLeast(nums[i])
        }

        val ans = IntArray(size - k + 1)
        for (i in 0..size - k) {
            // 关键代码，看懂这行就明白这个算法了
            ans[i] = suffixMax[i].coerceAtLeast(prefixMax[i + k - 1])
        }
        return ans
    }

}