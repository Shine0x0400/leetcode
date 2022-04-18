package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/18
 */
class Leet438_findAnagrams {

    fun findAnagrams(s: String, p: String): List<Int> {
        val count = hashMapOf<Char, Int>()
        p.forEach {
            count[it] = count.getOrDefault(it, 0) + 1
        }

        val ans = arrayListOf<Int>()
        var fast = 0
        var slow = 0

        while (fast < s.length) {
            val c = s[fast++]
            if (!count.containsKey(c)) {
                while (slow != fast - 1) {
                    count[s[slow]] = count[s[slow]]!! + 1
                    slow++
                }
                slow++
            } else {
                count[c] = count[c]!! - 1
                while (count[c]!! < 0) {
                    val h = s[slow]
                    count[h] = count[h]!! + 1
                    slow++
                }

                if (fast - slow == p.length) {
                    ans.add(slow)
                    count[s[slow]] = count[s[slow]]!! + 1
                    slow++
                }
            }
        }

        return ans
    }
}