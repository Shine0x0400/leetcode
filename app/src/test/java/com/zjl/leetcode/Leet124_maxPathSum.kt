package com.zjl.leetcode

import com.zjl.leetcode.datastructure.TreeNode

/**
 *
 *
 * @author zjl
 * @date  2022/3/21
 */
class Leet124_maxPathSum {
    var maxSum = -1000

    fun maxPathSum(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        maxContribute(root)
        return maxSum
    }

    /**
     * 计算该节点，可以为父节点贡献多少
     */
    private fun maxContribute(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }
        val left = maxContribute(node.left)
        val right = maxContribute(node.right)
        maxSum = maxSum.coerceAtLeast(node.`val` + left + right)

        // 如果为负数，就不参与贡献
        return (node.`val` + Math.max(left, right)).coerceAtLeast(0)
    }
}