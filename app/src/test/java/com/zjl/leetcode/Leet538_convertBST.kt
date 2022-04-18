package com.zjl.leetcode

import com.zjl.leetcode.datastructure.TreeNode

/**
 *
 *
 * @author zjl
 * @date  2022/4/20
 */
class Leet538_convertBST {
    var accumulate = 0

    fun convertBST(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        // R-M-L，逆向的中序遍历，就是从大到小的遍历过程
        convertBST(root.right)

        accumulate += root.`val`
        root.`val` = accumulate

        convertBST(root.left)
        return root
    }

    /**
     * Morris遍历
     */
    fun convertBST2(root: TreeNode?): TreeNode? {
        var sum = 0
        var p = root
        while (p != null) {
            if (p.right == null) {
                sum += p.`val`
                p.`val` = sum
                p = p.left
            } else {
                val successor = getSuccessor(p)
                if (successor.left == null) {
                    successor.left = p
                    p = p.right
                } else {
                    successor.left = null

                    sum += p.`val`
                    p.`val` = sum
                    p = p.left
                }
            }
        }
        return root
    }

    // 找p的前继节点
    private fun getSuccessor(p: TreeNode): TreeNode {
        var s = p.right
        while (s.left != null && s.left != p) {
            s = s.left
        }
        return s
    }
}