package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author dylannzhang
 * @date 2022/3/4
 */
class JZ57_2_findContinuousSequence {
    fun findContinuousSequence(target: Int): Array<IntArray> {
        val ans = arrayListOf<IntArray>()
        var i = 1
        var j = 2
        var sum = 3
        while (i < j) {
            if (sum == target) {
                ans.add(IntArray(j - i + 1) {
                    i + it
                })
                sum -= i
                i++

                j++
                sum += j
            } else if (sum < target) {
                j++
                sum += j
            } else {
                sum -= i
                i++
            }
        }

        return ans.toTypedArray()
    }
}