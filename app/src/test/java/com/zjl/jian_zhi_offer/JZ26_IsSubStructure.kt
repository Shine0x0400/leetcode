package com.zjl.jian_zhi_offer

import com.zjl.leetcode.datastructure.TreeNode

/**
 *
 *
 * @author zjl
 * @date  2021/12/25
 */
class JZ26_IsSubStructure {
    fun isSubStructure(A: TreeNode?, B: TreeNode?): Boolean {
        if (A == null || B == null) {
            return false
        }

        return isSubFromRoot(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)
    }

    private fun isSubFromRoot(a: TreeNode?, b: TreeNode?): Boolean {
        if (b == null) {
            return true
        }
        if (a == null) {
            return false
        }

        return a.`val` == b.`val` && isSubFromRoot(a.left, b.left) && isSubFromRoot(a.right, b.right)
    }
}