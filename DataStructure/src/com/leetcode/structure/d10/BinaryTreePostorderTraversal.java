package com.leetcode.structure.d10;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 左右中
 *
 * @author kar
 * @create 2021-11-29 22:43
 */
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        BinaryTreePostorderTraversal traversal = new BinaryTreePostorderTraversal();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(traversal.postorderTraversal1(root));
    }
    //迭代
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果本节点没有右子节点，则输出本节点
            // 如果上一个输出的节点是本节点的右子节点，则输出本节点。
            if (root.right == null || root.right == pre) {
                list.add(root.val);
                // 保存上一个输出的节点
                pre = root;
                root = null;
            }else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }

    // 递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            list.addAll(postorderTraversal(root.left));
        }
        if (root.right != null) {
            list.addAll(postorderTraversal(root.right));
        }
        list.add(root.val);
        return list;
    }
}
