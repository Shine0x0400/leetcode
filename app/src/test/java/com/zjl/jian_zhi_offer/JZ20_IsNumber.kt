package com.zjl.jian_zhi_offer

class JZ20_IsNumber {
    fun isNumber(s: String): Boolean {
        val trim = s.trim()
        if (trim.isEmpty()) {
            return false
        }

        var i = 0
        if (trim[i] == '+' || trim[i] == '-') {
            i++
        }

        var hasPoint = false
        var hasNumber = false
        var hasE = false

        while (i < trim.length) {
            if (trim[i] == '.') {
                if (hasPoint) {
                    return false
                }

                hasPoint = true
            } else if (trim[i] == 'e' || trim[i] == 'E') {
                hasE = true
                i++
                break
            } else if (trim[i] in '0'..'9') {
                hasNumber = true
                i++
                continue
            } else {
                return false
            }

            i++
        }

        if (!hasNumber) {
            return false
        }

        if (i >= trim.length) {
            return !hasE
        }

        hasNumber = false

        if (trim[i] == '+' || trim[i] == '-') {
            i++
        }

        while (i < trim.length) {
            if (trim[i++] !in '0'..'9') {
                return false
            }
            hasNumber = true
        }

        return hasNumber
    }
}