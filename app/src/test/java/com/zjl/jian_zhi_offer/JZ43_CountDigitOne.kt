package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author dylannzhang
 * @date 2022/2/21
 */
class JZ43_CountDigitOne {
    fun countDigitOne(n: Int): Int {
        var c = 0L

        var m = 1L
        while (m <= n) {
            val p = m * 10
            c += n / p * m
            val r = n % p
            if (r >= m * 2) {
                c += m
            } else if (r >= m) {
                c += r - m + 1
            }

            m *= 10
        }

        return c.toInt()
    }
}