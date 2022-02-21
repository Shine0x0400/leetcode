package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author dylannzhang
 * @date 2022/3/1
 */
class JZ50_firstUniqChar {
    fun firstUniqChar(s: String): Char {
        val count = hashMapOf<Char, Int>()
        for (i in s.indices) {
            count[s[i]] = count.getOrDefault(s[i], 0) + 1
        }

        for (i in s.indices) {
            val c = s[i]
            if (count[c] == 1) {
                return c
            }
        }

        return ' '
    }
}