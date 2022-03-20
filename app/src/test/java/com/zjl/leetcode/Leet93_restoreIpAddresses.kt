package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/7
 */
class Leet93_restoreIpAddresses {
    val ans = arrayListOf<String>()

    fun restoreIpAddresses(s: String): List<String> {
        dfs(s, ptr = 0, segment = 0, ip = "")
        return ans
    }

    private fun dfs(s: String, ptr: Int, segment: Int, ip: String) {
        if (segment == 4) {
            if (ptr == s.length) {
                ans.add(ip)
            }
            return
        }

        if (ptr == s.length) {
            return
        }

        if (s[ptr] == '0') {
            dfs(s, ptr + 1, segment + 1, "${ip}0${if (segment + 1 < 4) "." else ""}")
            return
        }

        var cur = 0
        for (i in ptr until s.length) {
            cur = cur * 10 + (s[i] - '0')
            if (cur in 1..0xFF) {
                dfs(s, i + 1, segment + 1, "${ip}${cur}${if (segment + 1 < 4) "." else ""}")
            } else {
                break
            }
        }
    }
}