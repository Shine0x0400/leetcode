package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author dylannzhang
 * @date 2022/2/24
 */
class JZ45_JointSmallestNumber {
    fun minNumber(nums: IntArray): String {
        val s = nums.sortedWith(Comparator<Int> { x, y ->
            "$x$y".compareTo("$y$x")
        })

        return StringBuilder().apply {
            s.forEach {
                append(it)
            }
        }.toString()
    }
}