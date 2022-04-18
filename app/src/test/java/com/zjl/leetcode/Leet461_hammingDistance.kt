package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/19
 */
class Leet461_hammingDistance {

    fun hammingDistance(x: Int, y: Int): Int {
        var a = x xor y
        var ans = 0
        while (a != 0) {
            ans += (a and 1)
            a = a shr 1
        }
        return ans
    }
}