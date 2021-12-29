package com.zjl.jian_zhi_offer

import com.zjl.leetcode.datastructure.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 *
 *
 * @author zjl
 * @date  2021/12/29
 */
class JZ32_1_LevelOrderPrintTree {
    fun levelOrder(root: TreeNode?): IntArray {
        if (root == null) {
            return IntArray(0)
        }

        val q = LinkedList<TreeNode>()
        val d = TreeNode(-1)
        q.add(root)
        q.add(d)
        val l = ArrayList<Int>()

        while (!q.isEmpty()) {
            val t = q.poll()
            if (t === d) {
                if (q.isEmpty()) {
                    break
                }
                q.add(t)
            } else {
                l.add(t.`val`)

                if (t.left != null) {
                    q.add(t.left)
                }
                if (t.right != null) {
                    q.add(t.right)
                }
            }
        }

        return l.toIntArray()
    }
}