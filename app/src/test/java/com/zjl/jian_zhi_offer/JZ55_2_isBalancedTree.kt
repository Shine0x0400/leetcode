package com.zjl.jian_zhi_offer

import com.zjl.leetcode.datastructure.TreeNode

/**
 *
 *
 * @author dylannzhang
 * @date 2022/3/3
 */
class JZ55_2_isBalancedTree {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }

        if (!isBalanced(root.left) || !isBalanced(root.right)) {
            return false
        }

        val lHeight = height(root.left)
        val rHeight = height(root.right)
        return Math.abs(lHeight - rHeight) <= 1
    }

    private fun height(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }

        return Math.max(height(node.left), height(node.right)) + 1
    }
}