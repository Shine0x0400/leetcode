package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author dylannzhang
 * @date 2022/2/22
 */
class JZ44_FindNthDigit {

    // https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/mian-shi-ti-44-shu-zi-xu-lie-zhong-mou-yi-wei-de-6/
    fun findNthDigit(n: Int): Int {
        var k = 1
        var start = 1L
        var count = 9L

        var r = n.toLong()
        while (r > count) {
            r -= count
            k++
            start *= 10
            count = 9 * start * k
        }

        val num = start + (r - 1) / k
        return num.toString()[((r - 1) % k).toInt()] - '0'
    }

    fun myFindNthDigit(n: Int): Int {
        if (n < 10) {
            return n
        }
        var k = 1 // 迭代数字长度
        var m = 10L
        var l = 0L // 累计长度，从0开始

        while (l < n) {
            val t = l + (m - m / 10) * k
            if (t > n) {
                break
            }
            l = t
            k++
            m *= 10
        }

        if (l == n.toLong()) {
            return 9
        }

        m /= 10

        val r = n - l
        val i = r / k
        val j = r % k

        return if (j == 0L) {
            val lastNum = m + i - 1
            (lastNum % 10).toInt()
        } else {
            val lastNum = m + i

            // 正向求第j位
            var q = m
            for (ii in 2..j) {
                q /= 10
            }
            (lastNum / q % 10).toInt()

//            // 逆向求倒数第rj位
//            val rj = k - j + 1
//            (lastNum / Math.pow(10.0, rj - 1.0).toLong() % 10).toInt()
        }
    }
}