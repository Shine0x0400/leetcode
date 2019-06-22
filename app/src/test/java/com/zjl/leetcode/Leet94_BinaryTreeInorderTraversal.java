package com.zjl.leetcode;

import com.zjl.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjl
 * @date 2019-06-21
 */
public class Leet94_BinaryTreeInorderTraversal {


    // using Morris Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode rightMost = cur.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }

                rightMost.right = cur;
                TreeNode tmp = cur.left;
                cur.left = null;
                cur = tmp;
            } else {
                list.add(cur.val);
                cur = cur.right;
            }
        }

        return list;
    }

//    // using recursion
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root == null) {
//            return Collections.emptyList();
//        }
//        List<Integer> list = new ArrayList<>();
//        list.addAll(inorderTraversal(root.left));
//        list.add(root.val);
//        list.addAll(inorderTraversal(root.right));
//
//        return list;
//    }


//    // using stack
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//
//        TreeNode p = root;
//
//        do {
//            while (p != null) {
//                stack.push(p);
//                p = p.left;
//            }
//
//            if (!stack.isEmpty()) {
//                TreeNode pop = stack.pop();
//                list.add(pop.val);
//                p = pop.right;
//            }
//
//        } while (!stack.isEmpty() || p != null);
//
//        return list;
//    }
}
