package com.leetcode.structure.d13;

import com.leetcode.structure.d10.TreeNode;

/**
 * 1、二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 *     // 二叉搜索树满足如下性质：
 *     //  左子树所有节点的元素值均小于根的元素值；
 *     //  右子树所有节点的元素值均大于根的元素值。
 *
 * @author Kar
 * @create 2021-12-02 下午5:17
 */
public class SearchInABinarySearchTree {

    // 迭代
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            root = root.val > val ? root.left : root.right;
        }
        return null;
    }

    // 递归
    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        return searchBST1(val < root.val ? root.left : root.right, val);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);
        return left != null ? left : right;
    }
}
