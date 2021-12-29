package com.zjl.jian_zhi_offer

import com.zjl.leetcode.datastructure.TreeNode

/**
 *
 *
 * @author zjl
 * @date  2021/12/29
 */
class JZ32_2_LevelOrderPrintTree {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = ArrayList<List<Int>>()

        var next = ArrayList<TreeNode>()
        if (root != null) {
            next.add(root)
        }

        while (next.isNotEmpty()) {
            var itr = ArrayList<TreeNode>()
            val l = next.map {
                if (it.left != null) {
                    itr.add(it.left)
                }
                if (it.right != null) {
                    itr.add(it.right)
                }
                it.`val`
            }
            result.add(l)
            next = itr
        }

        return result
    }
}