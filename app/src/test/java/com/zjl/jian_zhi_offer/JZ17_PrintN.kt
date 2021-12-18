package com.zjl.jian_zhi_offer

class JZ17_PrintN {
    fun printNumbers(n: Int): IntArray {
        val max = powOfTen(n) - 1
        return IntArray(max) {
            it + 1
        }
    }

    fun powOfTen(n: Int): Int {
        var r = 1
        var t = 10
        var p = n

        while (p > 0) {
            if (p % 2 == 1) {
                r *= t
            }

            t *= t
            p /= 2
        }

        return r
    }
}