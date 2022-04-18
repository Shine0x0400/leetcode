package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/19
 */
class Leet448_findDisappearedNumbers {

    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val set = (1..nums.size).toHashSet()
        nums.forEach {
            set.remove(it)
        }
        return set.toList()
    }

    // clever
    fun findDisappearedNumbers2(nums: IntArray): List<Int> {
        val n = nums.size
        nums.forEach {
            val hash = (it - 1) % n
            nums[hash] += n
        }

        val ans = arrayListOf<Int>()
        nums.forEachIndexed { i, v ->
            if (v <= n) {
                ans.add(i + 1)
            }
        }
        return ans
    }
}