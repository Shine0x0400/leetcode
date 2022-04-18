package com.zjl.leetcode

import com.zjl.leetcode.datastructure.TreeNode

/**
 *
 *
 * @author zjl
 * @date  2022/4/13
 */
class Leet337_rob {
    val map = hashMapOf<TreeNode, Int>()

    fun rob(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        if (map.containsKey(root)) {
            return map[root]!!
        }

        val select = root.`val` + rob(root.left?.left) + rob(root.left?.right) + rob(root.right?.left) + rob(root.right?.right)
        val unselect = rob(root.left) + rob(root.right)

        val ans = kotlin.math.max(select, unselect)
        map[root] = ans
        return ans
    }
}