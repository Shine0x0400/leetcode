package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/2
 */
class Leet1154_dayOfYear {

    fun dayOfYear(date: String): Int {
        val days = intArrayOf(
            31,// 1
            28,// 2, as Common Year
            31,// 3
            30,// 4
            31,// 5
            30,// 6
            31,// 7
            31,// 8
            30,// 9
            31,// 10
            30,// 11
            31// 12
        )
        val split = date.split("-").map {
            it.toInt()
        }

        var ans = split[2]
        for (i in 0 until split[1] - 1) {
            ans += days[i]
            if (i == 1 && isLeapYear(split[0])) {
                ans += 1
            }
        }

        return ans
    }

    private fun isLeapYear(year: Int): Boolean {
        if (year % 400 == 0) {
            return true
        }

        if (year % 100 == 0) {
            return false
        }

        return year % 4 == 0
    }
}