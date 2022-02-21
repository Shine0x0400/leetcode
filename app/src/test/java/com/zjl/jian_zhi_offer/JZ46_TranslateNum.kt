package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author dylannzhang
 * @date 2022/2/25
 */
class JZ46_TranslateNum {
    /**
     * 动态规划
     */
    fun translateNum(num: Int): Int {
        val s = num.toString()
        var cur = 0
        var pre1 = 0
        var pre2 = 0

        // 计算i处结尾的子串的翻译种数
        for (i in s.indices) {
            if (i == 0) {
                cur = 1
                pre1 = 1
            } else {
                cur = pre1
                val begin = s.substring(i - 1, i + 1)
                if (begin >= "10" && begin <= "25") {
                    cur += pre2
                }
            }

            pre2 = pre1
            pre1 = cur
        }

        return cur
    }

//    /**
//     * 递归
//     */
//    fun translateNum(num: Int): Int {
//        val digits = num.toString().toCharArray().map { it - '0' }
//        return recursive(digits, 0)
//    }
//
//    private fun recursive(chars: List<Int>, i: Int): Int {
//        if (i > chars.lastIndex) {
//            return 1
//        }
//
//        // 不考虑有前导0的情况，如01，00...
//        return recursive(chars, i + 1) + if (i < chars.lastIndex && chars[i] * 10 + chars[i + 1] < 26 && chars[i] * 10 + chars[i + 1] > 9) {
//            recursive(chars, i + 2)
//        } else 0
//    }
}