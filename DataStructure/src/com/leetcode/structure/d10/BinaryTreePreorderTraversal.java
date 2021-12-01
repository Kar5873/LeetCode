package com.leetcode.structure.d10;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 前序遍历
 *
 * 中左右
 *
 * @author kar
 * @create 2021-11-29 20:42
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        BinaryTreePreorderTraversal traversal = new BinaryTreePreorderTraversal();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(traversal.preorderTraversal(root));
    }

    // 迭代
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> preNode = new LinkedList();
        while (root != null || !preNode.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                preNode.push(root);
                root = root.left;
            }
            root = preNode.pop();
            root = root.right;
        }
        return list;
    }

    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root != null) {
            list.add(root.val);
            if (root.left != null) {
                List<Integer> list1 = preorderTraversal(root.left);
                list.addAll(list1);
            }
            if (root.right != null) {
                List<Integer> list2 = preorderTraversal(root.right);
                list.addAll(list2);
            }
        }
        return list;
    }


}
