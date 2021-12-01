package com.leetcode.structure.d12;

import com.leetcode.structure.d10.TreeNode;
import com.sun.org.apache.bcel.internal.generic.I2D;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Kar
 * @create 2021-12-01 下午12:23
 */
public class InvertBinaryTree {
    // 递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // 迭代
    public TreeNode invertTree1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.pop();
                if (node!=null){
                    stack.push(node.left);
                    stack.push(node.right);
                    node.right = node.left;
                    node.left = stack.peek();
                }
            }
        }
        return root;
    }
}
