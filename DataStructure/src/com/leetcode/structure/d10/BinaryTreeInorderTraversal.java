package com.leetcode.structure.d10;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 左中右
 * @author kar
 * @create 2021-11-29 22:00
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        BinaryTreeInorderTraversal traversal = new BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(traversal.inorderTraversal1(root));
    }

    // 迭代
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> preNode = new LinkedList<>();
        while (root != null || !preNode.isEmpty()) {
            while (root != null) {
                preNode.push(root);
                root = root.left;
            }
            root = preNode.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            list.addAll(inorderTraversal(root.left));
        }
        list.add(root.val);
        if (root.right != null) {
            list.addAll(inorderTraversal(root.right));
        }
        return list;
    }
}
