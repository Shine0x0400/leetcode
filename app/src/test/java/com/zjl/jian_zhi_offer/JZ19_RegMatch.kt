package com.zjl.jian_zhi_offer

class JZ19_RegMatch {
    fun isMatch(s: String, p: String): Boolean {
        val dp = Array(s.length + 1) { BooleanArray(p.length + 1) }
        dp[0][0] = true

        for (sLength in 0..s.length) {
            for (pLength in 0..p.length) {
                if (sLength == 0 && pLength == 0) {
                    continue
                }

                if (pLength == 0) {
                    dp[sLength][pLength] = false
                    continue
                }

                dp[sLength][pLength] = if (p[pLength - 1] == '*') {
                    dp[sLength][pLength - 2]
                            || (sLength > 0 && (s[sLength - 1] == p[pLength - 2] || p[pLength - 2] == '.') && dp[sLength - 1][pLength])
                } else {
                    sLength > 0 && (p[pLength - 1] == '.' || p[pLength - 1] == s[sLength - 1]) && dp[sLength - 1][pLength - 1]
                }
            }
        }


        return dp[s.length][p.length]
    }
}