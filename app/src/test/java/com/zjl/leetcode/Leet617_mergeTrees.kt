package com.zjl.leetcode

import com.zjl.leetcode.datastructure.TreeNode

/**
 *
 *
 * @author zjl
 * @date  2022/4/21
 */
class Leet617_mergeTrees {

    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        if (root1 == null) {
            return root2
        }
        if (root2 == null) {
            return root1
        }

        val n = TreeNode(root1.`val` + root2.`val`)
        n.left = mergeTrees(root1.left, root2.left)
        n.right = mergeTrees(root1.right, root2.right)
        return n
    }
}