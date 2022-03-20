package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/3/26
 */
class Leet198_rob {

    fun rob(nums: IntArray): Int {
        // 以下两个数组，表示从index处开始打劫，包含和不包含分别的最大窃资
        val contain = IntArray(nums.size)
        val notContain = IntArray(nums.size)
        contain[contain.lastIndex] = nums.last()
        notContain[notContain.lastIndex] = 0

        for (i in nums.lastIndex - 1 downTo 0) {
            contain[i] = nums[i] + notContain[i + 1]
            notContain[i] = Math.max(contain[i + 1], notContain[i + 1])
        }

        return Math.max(contain[0], notContain[0])
    }
}