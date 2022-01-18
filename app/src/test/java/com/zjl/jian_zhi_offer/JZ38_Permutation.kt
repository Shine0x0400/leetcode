package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author dylannzhang
 * @date 2022/1/18
 */
class JZ38_Permutation {
    val perms = mutableListOf<String>()
    lateinit var visit: BooleanArray

    /**
     * 回溯法
     */
    fun permutation_backtrack(s: String): Array<String> {
        visit = BooleanArray(s.length)

        val chars = s.toCharArray()
        chars.sort()
        val b = StringBuilder()
        backtrack(chars, b)

        return perms.toTypedArray()
    }

    private fun backtrack(chars: CharArray, b: StringBuilder) {
        if (b.length == chars.size) {
            perms.add(b.toString())
            return
        }

        chars.forEachIndexed { i, c ->
            if (visit[i]
                || (i > 0 && chars[i - 1] == chars[i] && !visit[i - 1]) // 跳过连续相同的字符, 因为会产生重复的排列
            ) {
                return@forEachIndexed
            }

            b.append(c)
            visit[i] = true
            backtrack(chars, b)
            b.deleteCharAt(b.length - 1)
            visit[i] = false
        }
    }

    /**
     * 逐个生成下一个序列
     */
    fun permutation(s: String): Array<String> {
        val result = mutableListOf<String>()

        val chars = s.toCharArray()
        chars.sort()
        do {
            result.add(String(chars))
        } while (nextPermutation(chars))

        return result.toTypedArray()
    }

    // 生成下一个字典序排列
    private fun nextPermutation(chars: CharArray): Boolean {
        var i = chars.lastIndex - 1
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--
        }

        if (i < 0) {
            return false
        }

        var j = chars.lastIndex
        while (chars[j] <= chars[i]) {
            j--
        }

        swap(chars, i, j)
        reverse(chars, i + 1)
        return true
    }

    private fun reverse(chars: CharArray, from: Int) {
        var left = from
        var right = chars.lastIndex
        while (left < right) {
            swap(chars, left, right)
            left++
            right--
        }
    }

    private fun swap(chars: CharArray, i: Int, j: Int) {
        val tmp = chars[i]
        chars[i] = chars[j]
        chars[j] = tmp
    }


    /**
     * mine: 递归穷举
     */
//    fun permutation(s: String): Array<String> {
//        val chars = s.toCharArray().toMutableList()
//        return recursive(chars).map { String(it.toCharArray()) }.toSet().toTypedArray()
//    }
//
//    private fun recursive(chars: MutableList<Char>): List<List<Char>> {
//        val result = mutableListOf<List<Char>>()
//        if (chars.size == 1) {
//            result.add(listOf(chars[0]))
//            return result
//        }
//
//        chars.indices.forEach {
//            val c = chars[it]
//            val r = recursive(chars.apply { removeAt(it) })
//
//            r.forEach { list ->
//                for (i in 0..list.size) {
//                    result.add(list.toMutableList().apply { add(i, c) })
//                }
//            }
//
//            chars.add(it, c)
//        }
//
//        return result.distinctBy { String(it.toCharArray()) }
//    }
}