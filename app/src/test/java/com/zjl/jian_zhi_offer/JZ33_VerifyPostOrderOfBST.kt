package com.zjl.jian_zhi_offer

/**
 * 校验二叉搜索树的后序遍历序列
 *
 * @author zjl
 * @date  2022/1/9
 */
class JZ33_VerifyPostOrderOfBST {
    fun verifyPostorder(postorder: IntArray): Boolean {
        return verifyPostorder(postorder, 0, postorder.size - 1)
    }

    private fun verifyPostorder(postorder: IntArray, s: Int, e: Int): Boolean {
        if (s >= e) {
            return true
        }

        val r = postorder[e]
        var i = e
        for (j in s until e) {
            if (postorder[j] > r) {
                i = j
                break
            }
        }

        for (j in i until e) {
            if (postorder[j] < r) {
                return false
            }
        }

        return verifyPostorder(postorder, s, i - 1) && verifyPostorder(postorder, i, e - 1)
    }
}