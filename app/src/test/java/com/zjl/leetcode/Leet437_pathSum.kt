package com.zjl.leetcode

import com.zjl.leetcode.datastructure.TreeNode

/**
 *
 *
 * @author zjl
 * @date  2022/4/17
 */
fun main() {
    val root = TreeNode(1).apply {
        right = TreeNode(2).apply {
            right = TreeNode(3).apply {
                right = TreeNode(4).apply {
                    left = TreeNode(5)
                }
            }
        }
    }

    val result = Leet437_pathSum().pathSumRecursive(root, 3)
}

class Leet437_pathSum {

    var ans = 0
    var t = 0
    var prefixSum = hashMapOf<Int, Int>()

    /**
     * 前缀和
     */
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        t = targetSum
        ans = 0
        prefixSum.clear()
        prefixSum[0] = 1
        dfs(root, 0)
        return ans
    }

    private fun dfs(root: TreeNode?, accumulate: Int) {
        if (root == null) {
            return
        }
        val cur = accumulate + root.`val`
        ans += (prefixSum[cur - t] ?: 0)

        prefixSum[cur] = (prefixSum[cur] ?: 0) + 1
        dfs(root.left, cur)
        dfs(root.right, cur)
        prefixSum[cur] = prefixSum[cur]!! - 1
    }

    /**
     * 递归
     */
    fun pathSumRecursive(root: TreeNode?, targetSum: Int): Int {
        if (root == null) {
            return 0
        }

        return rootSum(root, targetSum) + pathSumRecursive(root.left, targetSum) + pathSumRecursive(root.right, targetSum)
    }

    // 以root为起点的路径数
    private fun rootSum(root: TreeNode?, targetSum: Int): Int {
        if (root == null) {
            return 0
        }

        var ans = 0
        if (targetSum == root.`val`) {
            ans++
        }
        ans += rootSum(root.left, targetSum - root.`val`)
        ans += rootSum(root.right, targetSum - root.`val`)
        return ans
    }

}