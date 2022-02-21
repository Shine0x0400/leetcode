package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author dylannzhang
 * @date 2022/3/3
 */
class JZ56_2_singleNumber {
    fun singleNumber(nums: IntArray): Int {
        val bits = IntArray(32)
        nums.forEach {
            for (i in 0..31) {
                bits[i] = (bits[i] + (it shr i and 1)) % 3
            }
        }

        var ans = 0
        bits.forEachIndexed { i, v ->
            if (v != 0) {
                ans = ans or (1 shl i)
            }
        }
        return ans
    }
}