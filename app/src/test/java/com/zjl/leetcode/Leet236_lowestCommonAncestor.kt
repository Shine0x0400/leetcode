package com.zjl.leetcode

import com.zjl.leetcode.datastructure.TreeNode

/**
 *
 *
 * @author zjl
 * @date  2022/4/1
 */
class Leet236_lowestCommonAncestor {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || root == p || root == q) {
            return root
        }
        val l = lowestCommonAncestor(root.left, p, q)
        val r = lowestCommonAncestor(root.right, p, q)
        return if (l == null) r else if (r == null) l else root
    }
}