package com.zjl.jian_zhi_offer

import com.zjl.leetcode.datastructure.TreeNode

/**
 *
 *
 * @author zjl
 * @date  2021/12/25
 */
class JZ27_MirroTree {
    fun mirrorTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        root.left = root.right.also { root.right = root.left }
        mirrorTree(root.left)
        mirrorTree(root.right)

        return root
    }
}