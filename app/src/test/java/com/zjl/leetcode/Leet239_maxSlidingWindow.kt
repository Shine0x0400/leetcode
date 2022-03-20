package com.zjl.leetcode

import java.util.*

/**
 *
 *
 * @author zjl
 * @date  2022/4/1
 */
class Leet239_maxSlidingWindow {

    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        // save indices in descend order
        val descendQueue = LinkedList<Int>()

        val ans = IntArray(nums.size - k + 1)
        for (i in 0 until k) {
            while (descendQueue.isNotEmpty() && nums[descendQueue.last] <= nums[i]) {
                descendQueue.removeLast()
            }
            descendQueue.add(i)
        }
        ans[0] = nums[descendQueue.first]
        for (i in k..nums.lastIndex) {
            while (descendQueue.isNotEmpty() && (i - descendQueue.first + 1) > k) {
                descendQueue.removeFirst()
            }

            while (descendQueue.isNotEmpty() && nums[descendQueue.last] <= nums[i]) {
                descendQueue.removeLast()
            }
            descendQueue.add(i)

            ans[i - k + 1] = nums[descendQueue.first]
        }
        return ans
    }
}