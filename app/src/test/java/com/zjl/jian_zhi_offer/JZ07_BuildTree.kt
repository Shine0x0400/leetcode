package com.zjl.jian_zhi_offer

import com.zjl.leetcode.datastructure.TreeNode

class JZ07_BuildTree {
    private val indexMap = hashMapOf<Int, Int>()
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        for (i in inorder.indices) {
            indexMap[inorder[i]] = i
        }
        return buildTree(preorder, inorder, 0, preorder.size, 0, inorder.size)
    }

    fun buildTree(
        preorder: IntArray,
        inorder: IntArray,
        preL: Int,
        preR: Int,
        inL: Int,
        inR: Int
    ): TreeNode? {
        var t: TreeNode? = null
        if (preL < preR) {
            val v = preorder[preL]
            t = TreeNode(v)
            val pos: Int = indexMap[v]!!
            t.left = buildTree(preorder, inorder, preL + 1, preL + 1 + (pos - inL), inL, pos)
            t.right = buildTree(preorder, inorder, preL + 1 + (pos - inL), preR, pos + 1, inR)
        }
        return t
    }
}