package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/14
 */
class Leet347_topKFrequent {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val counts = hashMapOf<Int, Int>()
        nums.forEach {
            counts[it] = (counts[it] ?: 0) + 1
        }

        val ans = IntArray(k)
        val keys = counts.keys.toIntArray()
        qsort(counts, keys, 0, keys.lastIndex, ans)
        return ans
    }

    private fun qsort(counts: HashMap<Int, Int>, keys: IntArray, start: Int, end: Int, ans: IntArray) {
        // random是避免，对于已排序数组，每次选第一个元素都是最大的情况（最坏情况）
        val pivot = (start..end).random()
        val f = counts[keys[pivot]]!!
        swap(keys, start, pivot)

        var index = start + 1
        for (i in start + 1..end) {
            if (counts[keys[i]]!! >= f) {
                swap(keys, index, i)
                index++
            }
        }

        if (index == ans.size) {
            for (i in 0..ans.lastIndex) {
                ans[i] = keys[i]
            }
        } else if (index < ans.size) {
            qsort(counts, keys, index, end, ans)
        } else {
            qsort(counts, keys, start, index - 1, ans)
        }
    }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        arr[i] = arr[j].also { arr[j] = arr[i] }
    }
}