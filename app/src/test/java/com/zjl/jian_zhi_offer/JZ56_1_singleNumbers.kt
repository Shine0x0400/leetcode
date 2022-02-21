package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author dylannzhang
 * @date 2022/3/3
 */
class JZ56_1_singleNumbers {
    fun singleNumbers(nums: IntArray): IntArray {
        var a = 0
        nums.forEach {
            a = a xor it
        }

        // 找到是1的位
        var b = 1
        while (b and a == 0) {
            b = b shl 1
        }

        var m = 0
        var n = 0
        nums.forEach {
            if (it and b != 0) {
                m = m xor it
            } else {
                n = n xor it
            }
        }

        return intArrayOf(m, n)
    }
}