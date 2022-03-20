package com.zjl.leetcode

import com.zjl.leetcode.datastructure.TreeNode

/**
 *
 *
 * @author zjl
 * @date  2022/3/20
 */
class Leet114_flattenTree {

    fun flatten(root: TreeNode?): Unit {
        var p = root
        while (p != null) {
            if (p.left != null) {
                val r = p.right
                p.right = p.left
                p.left = null

                var q = p.right
                while (q.right != null) {
                    q = q.right
                }
                q.right = r
            }

            p = p.right
        }
    }

//    /**
//     * recursive
//     */
//    fun flatten(root: TreeNode?): Unit {
//        if (root == null) {
//            return
//        }
//
//        flatten(root.left)
//        flatten(root.right)
//        val right = root.right
//        root.right = root.left
//        root.left = null
//        var p: TreeNode = root
//        while (p.right != null) {
//            p = p.right
//        }
//        p.right = right
//    }
}