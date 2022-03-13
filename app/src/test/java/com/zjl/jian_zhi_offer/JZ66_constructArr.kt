package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author zjl
 * @date  2022/3/14
 */
class JZ66_constructArr {
    fun constructArr(a: IntArray): IntArray {
        val ans = IntArray(a.size) {
            1
        }
        // 下三角乘积
        var down = 1
        // 上三角乘积
        var up = 1
        for (i in ans.indices) {
            ans[i] *= down
            down *= a[i]

            ans[ans.lastIndex - i] *= up
            up *= a[a.lastIndex - i]
        }

        return ans
    }
}