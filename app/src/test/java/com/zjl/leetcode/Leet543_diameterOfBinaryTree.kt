package com.zjl.leetcode

import com.zjl.leetcode.datastructure.TreeNode

/**
 *
 *
 * @author zjl
 * @date  2022/4/20
 */
class Leet543_diameterOfBinaryTree {

    var diameter = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        recursive(root)
        return diameter
    }

    private fun recursive(root: TreeNode?): Int {
        if (root == null) {
            return -1
        }
        val l = recursive(root.left) + 1
        val r = recursive(root.right) + 1

        diameter = diameter.coerceAtLeast(l + r)
        return kotlin.math.max(l, r)
    }
}