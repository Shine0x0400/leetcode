package com.zjl.jian_zhi_offer

import com.zjl.leetcode.datastructure.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 *
 *
 * @author zjl
 * @date  2022/1/9
 */
class JZ34_PathSum {
    val result = ArrayList<ArrayList<Int>>()
    var sum = 0
    val list = LinkedList<Int>()

    fun pathSum(root: TreeNode?, target: Int): List<List<Int>> {
        if (root == null) {
            return result
        }

        preOrderTraverse(root, target)
        return result
    }

    private fun preOrderTraverse(root: TreeNode, target: Int) {
        sum += root.`val`
        list.addLast(root.`val`)

        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(ArrayList(list))
            }
        }

        if (root.left != null) {
            preOrderTraverse(root.left, target)
        }
        if (root.right != null) {
            preOrderTraverse(root.right, target)
        }

        sum -= root.`val`
        list.removeLast()
    }
}