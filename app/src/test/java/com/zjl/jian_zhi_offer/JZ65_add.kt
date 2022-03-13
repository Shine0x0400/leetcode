package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author zjl
 * @date  2022/3/14
 */
class JZ65_add {
    fun add(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            x = (x xor y).also { y = (x and y) shl 1 }
        }
        return x
    }
}