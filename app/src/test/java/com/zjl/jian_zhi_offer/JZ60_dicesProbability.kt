package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author zjl
 * @date  2022/3/12
 */
fun main() {
    JZ60_dicesProbability().dicesProbabilityWithArray(3)
}

class JZ60_dicesProbability {
    fun dicesProbability(n: Int): DoubleArray {
        val p = 1.0 / 6.0
        var map = hashMapOf<Int, Double>()
        for (i in 1..6) {
            map[i] = p
        }

        for (i in 2..n) {
            val temp = hashMapOf<Int, Double>()
            for (i in 1..6) {
                map.forEach { (t, u) ->
                    temp[t + i] = temp.getOrDefault(t + i, 0.0) + u * p
                }
            }
            map = temp
        }

        return DoubleArray(n * 6 - n + 1) {
            map[it + n]!!
        }
    }

    // 不用哈希表，直接用数组
    fun dicesProbabilityWithArray(n: Int): DoubleArray {
        var ans = DoubleArray(6) {
            1 / 6.0
        }

        for (i in 2..n) {
            val temp = DoubleArray(i * 6 - i + 1)
            for (j in 0..5) {
                ans.forEachIndexed { index, d ->
                    temp[index + j] += d / 6
                }
            }
            ans = temp
        }

        return ans
    }
}