package com.leetcode.structure.d14;

import com.leetcode.structure.d10.TreeNode;

import java.util.*;

/**
 * @author Kar
 * @create 2021-12-03 下午5:43
 */
public class TwoSumIVInputIsABST {

    // 方法二：使用 BFS 和 HashSet (层序遍历）
    public boolean findTarget2(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

        }
        return false;
    }


    // 方法一：使用 HashSet
    public boolean findTarget1(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    private boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }

    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.poll();
            list.add(root.val);
            root = root.right;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) + list.get(i) == k) {
                    return true;
                }
            }
        }
        return false;
    }
}
