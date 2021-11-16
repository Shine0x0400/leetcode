package com.zjl.jian_zhi_offer

class JZ10_2_ClimbStairWays {

    // 推导矩阵递推关系，计算矩阵快速幂
    // https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/solution/fei-bo-na-qi-shu-lie-by-leetcode-solutio-hbss/
    fun numWays(n: Int): Int {
        if (n < 2) {
            return 1
        }

        val m = Array(2) { IntArray(2) }
        m[0][0] = 1
        m[0][1] = 1
        m[1][0] = 1
        m[1][1] = 0

        val mi = power(m, n-1)
        val mod = 1000000007
        return ((mi[0][0].toLong() + mi[0][1]) % mod).toInt()
    }

    private fun power(m: Array<IntArray>, n: Int): Array<IntArray> {
        // 单位矩阵
        var ret = Array(2) {
            if (it == 0) {
                intArrayOf(1, 0)
            } else {
                intArrayOf(0, 1)
            }
        }

        var a = m
        var i = n

        while (i > 0) {
            if (i % 2 == 1) {
                ret = multiply(ret, a)
            }

            a = multiply(a, a)
            i = i shr 1
        }

        return ret
    }

    // 2x2矩阵的乘法
    private fun multiply(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray> {
        val m = Array(2) { IntArray(2) }
        val mod = 1000000007
        for (i in 0..1) {
            for (j in 0..1) {
                m[i][j] = ((a[i][0].toLong() * b[0][j].toLong() + a[i][1].toLong() * b[1][j].toLong()) % mod).toInt()
            }
        }
        return m
    }
}