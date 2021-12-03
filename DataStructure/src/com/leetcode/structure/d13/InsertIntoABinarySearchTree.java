package com.leetcode.structure.d13;

import com.leetcode.structure.d10.TreeNode;

/**
 * 二叉搜索树中的插入操作
 *
 * @author Kar
 * @create 2021-12-03 上午10:47
 */
public class InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        InsertIntoABinarySearchTree insert = new InsertIntoABinarySearchTree();
        insert.insertIntoBST(null, 1);
    }

    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode head = root;
        while (root != null){
            if (root.val > val){
                if (root.left == null){
                    root.left = new TreeNode(val);
                    break;
                }
                root = root.left;
            }else {
                if (root.right == null){
                    root.right = new TreeNode(val);
                    break;
                }
                root = root.right;
            }
        }
        return head;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
