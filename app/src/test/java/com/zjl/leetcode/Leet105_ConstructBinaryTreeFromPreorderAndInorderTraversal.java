package com.zjl.leetcode;

import com.zjl.leetcode.datastructure.TreeNode;

/**
 * @author zjl
 * @date 2019-07-03
 */
public class Leet105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTreeInternal(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeInternal(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (pe < ps) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[ps]);

        int i = is;
        for (; i <= ie; i++) {
            if (inorder[i] == preorder[ps]) {
                break;
            }
        }

        // error input
        if (i > ie) {
            return null;
        }

        int leftLength = i - is;

        root.left = buildTreeInternal(preorder, ps + 1, ps + leftLength, inorder, is, i - 1);
        root.right = buildTreeInternal(preorder, ps + leftLength + 1, pe, inorder, i + 1, ie);

        return root;
    }
}
