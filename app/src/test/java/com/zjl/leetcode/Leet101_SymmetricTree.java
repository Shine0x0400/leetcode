package com.zjl.leetcode;

import com.zjl.leetcode.datastructure.TreeNode;

/**
 * @author zjl
 * @date 2019-07-03
 */
public class Leet101_SymmetricTree {

    // using Recursion
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricInternal(root, root);
    }

    private boolean isSymmetricInternal(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 != null && tree2 != null) {
            return tree1.val == tree2.val
                    && isSymmetricInternal(tree1.left, tree2.right)
                    && isSymmetricInternal(tree1.right, tree2.left);
        }

        return false;
    }

//    // level order traversal
//    public boolean isSymmetric(TreeNode root) {
//        Queue<TreeNode> left = new LinkedList<>();
//        Queue<TreeNode> right = new LinkedList<>();
//        left.add(root);
//        right.add(root);
//
//        while (!left.isEmpty() && !right.isEmpty()) {
//            TreeNode currentL = left.remove();
//            TreeNode currentR = right.remove();
//
//            if (currentL != null) {
//                if (currentR == null) {
//                    return false;
//                }
//
//                if (currentL.val != currentR.val) {
//                    return false;
//                }
//
//                left.add(currentL.left);
//                left.add(currentL.right);
//
//                right.add(currentR.right);
//                right.add(currentR.left);
//            } else {
//                if (currentR != null) {
//                    return false;
//                }
//            }
//        }
//
//        return left.isEmpty() && right.isEmpty();
//    }


}
