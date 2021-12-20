package com.zjl.jian_zhi_offer

class JZ21_Exchange {
    fun exchange(nums: IntArray): IntArray {
        var i = 0
        var j = nums.size - 1

        while (i < j) {
            while (i < j && nums[i] % 2 == 1) {
                i++
            }

            while (i < j && nums[j] % 2 == 0) {
                j--
            }

            if (i < j) {
                val t = nums[i]
                nums[i] = nums[j]
                nums[j] = t
            }
        }

        return nums
    }
}