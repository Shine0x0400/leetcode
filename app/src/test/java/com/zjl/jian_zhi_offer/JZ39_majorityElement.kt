package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author zjl
 * @date  2022/3/22
 */
class JZ39_majorityElement {

    /**
     * 博耶-摩尔多数投票算法
     */
    fun majorityElement(nums: IntArray): Int {
        var count = 0
        var num = 0
        nums.forEach {
            if (count == 0) {
                num = it
            }
            if (it == num) count++ else count--
        }

        return num
    }
}