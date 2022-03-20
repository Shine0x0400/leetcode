package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/3/18
 */
class Leet39_combinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val ans = arrayListOf<ArrayList<Int>>()
        val combine = arrayListOf<Int>()
        backtrace(candidates, target, 0, combine, ans)
        return ans
    }

    private fun backtrace(candidates: IntArray, target: Int, index: Int, combine: ArrayList<Int>, ans: ArrayList<ArrayList<Int>>) {
        if (target == 0) {
            ans.add(ArrayList(combine))
            return
        }

        if (index >= candidates.size) {
            return
        }

        // skip current index
        backtrace(candidates, target, index + 1, combine, ans)

        // add current element
        if (target - candidates[index] >= 0) {
            combine.add(candidates[index])
            backtrace(candidates, target - candidates[index], index, combine, ans)
            // 重点：要做恢复
            combine.removeAt(combine.lastIndex)
        }
    }
}