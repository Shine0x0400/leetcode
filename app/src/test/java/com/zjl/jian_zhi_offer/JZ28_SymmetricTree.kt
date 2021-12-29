package com.zjl.jian_zhi_offer

import com.zjl.leetcode.datastructure.TreeNode

/**
 *
 *
 * @author zjl
 * @date  2021/12/25
 */
class JZ28_SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        return recursive(root, root)
    }

    private fun recursive(t1: TreeNode?, t2: TreeNode?): Boolean {
        if (t1 == null && t2 == null) {
            return true
        }

        if (t1 == null || t2 == null) {
            return false
        }

        return t1.`val` == t2.`val` && recursive(t1.left, t2.right) && recursive(t1.right, t2.left)
    }
}