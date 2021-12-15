package com.zjl.jian_zhi_offer

class JZ16_Pow {
    fun myPow(x: Double, n: Int): Double {
        var result = 1.0
        var t = x
        var p = kotlin.math.abs(n.toLong())

        while (p > 0) {
            if (p % 2 == 1L) {
                result *= t
            }

            t *= t
            p /= 2
        }

        return if (n < 0) 1.0 / result else result
    }
}