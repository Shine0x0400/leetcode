package com.zjl.jian_zhi_offer

import com.zjl.leetcode.datastructure.TreeNode

/**
 *
 *
 * @author dylannzhang
 * @date 2022/3/3
 */
class JZ54_KthLargestOfBST {
    var count = 0
    var ans = -1

    fun kthLargest(root: TreeNode?, k: Int): Int {
        if (root == null) {
            return -1
        }
        count = k
        inOrderVisit(root)
        return ans
    }

    private fun inOrderVisit(node: TreeNode) {
        if (count == 0) {
            return
        }
        if (node.right != null) {
            inOrderVisit(node.right)
        }

        if (count == 0) {
            return
        }
        count--
        if (count == 0) {
            ans = node.`val`
            return
        }

        if (node.left != null) {
            inOrderVisit(node.left)
        }
    }
}