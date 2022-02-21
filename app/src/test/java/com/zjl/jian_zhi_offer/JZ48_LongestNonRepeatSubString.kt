package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author dylannzhang
 * @date 2022/2/28
 */
class JZ48_LongestNonRepeatSubString {
    fun lengthOfLongestSubstring(s: String): Int {
        val m = HashMap<Char, Int>()
        var result = 0
        var i = 0
        var j = 0
        while (j < s.length) {
            val c = s[j]
            if (m.containsKey(c)) {
                val occur = m[c]!!
                i = i.coerceAtLeast(occur + 1)
            }
            m[c] = j
            result = result.coerceAtLeast(j - i + 1)

            j++
        }

        return result
    }
}