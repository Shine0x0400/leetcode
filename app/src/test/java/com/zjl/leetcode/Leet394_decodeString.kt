package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/15
 */
class Leet394_decodeString {
    var index = 0

    fun decodeString(s: String): String {
        index = 0
        return decode(s)
    }

    private fun decode(s: String): String {
        val b = StringBuilder()
        while (index < s.length) {
            if (s[index] in 'a'..'z') b.append(s[index++])
            else if (s[index] in '0'..'9') {
                val count = decodeInteger(s)
                val sub = decode(s)
                for (i in 1..count) {
                    b.append(sub)
                }
            } else if (s[index] == ']') {
                index++
                break
            } else index++
        }
        return b.toString()
    }

    private fun decodeInteger(s: String): Int {
        var a = 0
        while (s[index] in '0'..'9') {
            a = a * 10 + (s[index++] - '0')
        }
        return a
    }
}