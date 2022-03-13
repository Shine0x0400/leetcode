package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author zjl
 * @date  2022/3/14
 */
class JZ67_strToInt {
    fun strToInt(str: String): Int {
        var i = 0
        while (i < str.length && str[i] == ' ') {
            i++
        }
        if (i >= str.length) {
            return 0
        }
        var sign = 1
        when (str[i]) {
            '+' -> {
                i++
            }
            '-' -> {
                sign = -1
                i++
            }
        }

        val boundary = Int.MAX_VALUE / 10
        val remain = Int.MAX_VALUE % 10
        var num = 0
        while (i < str.length && str[i] in '0'..'9') {
            val v = str[i] - '0'
            // 精髓：越界判断的方法
            if (num > boundary || (num == boundary && v > remain)) {
                return if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
            }
            num *= 10
            num += v

            i++
        }

        return num * sign
    }

//    fun strToInt(str: String): Int {
//        var i = 0
//        while (i < str.length && str[i] == ' ') {
//            i++
//        }
//        if (i >= str.length) {
//            return 0
//        }
//        var positive = true
//        when (str[i]) {
//            '+' -> {
//                positive = true
//                i++
//            }
//            '-' -> {
//                positive = false
//                i++
//            }
//            in '0'..'9' -> {
//                positive = true
//            }
//            else -> {
//                return 0
//            }
//        }
//
//        var num = 0L
//        var real = 0L
//        while (i < str.length && str[i] in '0'..'9') {
//            num *= 10
//            num += str[i] - '0'
//            real = if (positive) num else -num
//            if (real < Int.MIN_VALUE) {
//                return Int.MIN_VALUE
//            }
//            if (real > Int.MAX_VALUE) {
//                return Int.MAX_VALUE
//            }
//            i++
//        }
//
//        return real.toInt()
//    }
}