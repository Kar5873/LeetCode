package com.leetcode.structure.d11;

import com.leetcode.structure.d10.TreeNode;
import com.sun.media.sound.FFT;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author kar
 * @create 2021-11-30 21:03
 */
public class SymmetricTree {
    public static void main(String[] args) {
        SymmetricTree tree = new SymmetricTree();
        // [1,2,2,3,4,4,3]
        System.out.println(tree.isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(3), null), new TreeNode(2, new TreeNode(3), null))));
    }


    // 递归
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            // if (p.val == q.val) {
            //     boolean check1 = check(p.left, q.right);
            //     boolean check2 = check(p.right, q.left);
            //     return check1 && check2;
            // } else {
            //     return false;
            // }
            return (p.val == q.val) && check(p.left, q.right) && check(p.right, q.left);
        }
        return (p == null && q == null);
    }

    // 迭代
    public boolean isSymmetric2(TreeNode root) {
        return check2(root, root);
    }

    public boolean check2(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }


    // 迭代
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                TreeNode node = queue.poll();
                list.add(node != null ? node.val : Integer.MIN_VALUE);
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            int size = list.size();
            for (int i = 0; i < size / 2; i++) {
                if (!list.get(i).equals(list.get(size - 1 - i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
