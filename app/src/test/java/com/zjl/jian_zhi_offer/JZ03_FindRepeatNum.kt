package com.zjl.jianzhioffer.problems

class JZ03_FindRepeatNum {
    fun findRepeatNumber(nums: IntArray): Int {
        val occur = IntArray(nums.size)
        nums.forEach {
            occur[it] = occur[it] + 1
            if (occur[it] > 1) {
                return it
            }
        }

        return -1
    }
}