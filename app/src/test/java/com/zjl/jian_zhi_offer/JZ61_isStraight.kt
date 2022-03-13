package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author zjl
 * @date  2022/3/12
 */
fun main() {
    JZ61_isStraight().isStraight(intArrayOf(0, 4, 7, 0, 0))
}

class JZ61_isStraight {
    /**
     * 是顺子的充分条件是：无非0重复，且非零的max-min < 5
     */
    fun isStraight(nums: IntArray): Boolean {
        val set = hashSetOf<Int>()
        var min = 0
        var max = 0
        nums.forEach {
            if (it != 0) {
                if (!set.add(it)) {
                    return false
                }
                min = if (min == 0) it else min.coerceAtMost(it)
                max = if (max == 0) it else max.coerceAtLeast(it)
            }
        }

        return max - min < 5
    }

//    fun isStraight(nums: IntArray): Boolean {
//        nums.sort()
//        var zeroCount = 0
//        nums.forEachIndexed { i, v ->
//            if (v == 0) {
//                zeroCount++
//            } else {
//                if (i > 0 && nums[i - 1] != 0) {
//                    val gap = v - nums[i - 1]
//                    if (gap < 1) {
//                        return false
//                    }
//                    zeroCount -= (gap - 1)
//                }
//            }
//        }
//        return zeroCount >= 0
//    }
}