package com.leetcode.structure.d14;

import com.leetcode.structure.d10.TreeNode;

import java.util.*;

/**
 * 3、二叉搜索树的最近公共祖先
 * <p>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * @author kar
 * @create 2021-12-04 22:35
 */
public class LowestCommonAncestorOfABinarySearchTree {


    // 一次遍历
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true){
            if (root.val > q.val && root.val > p.val) {
                root = root.left;
            }else if (root.val < q.val && root.val < p.val){
                root = root.right;
            }else {
                return root;
            }
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_p = getPath1(root, p);
        List<TreeNode> path_q = getPath1(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    public List<TreeNode> getPath1(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<TreeNode>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }

    // 两次遍历
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> pList = getPath(root, p);
        Queue<TreeNode> qList = getPath(root, q);
        TreeNode preNode = null;
        while (pList.peek() == qList.peek()) {
            preNode = pList.poll();
            qList.remove();
        }
        return preNode;
    }

    private Queue<TreeNode> getPath(TreeNode root, TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        if (root.val > target.val) {
            queue.addAll(getPath(root.left, target));
        } else if (root.val < target.val) {
            queue.addAll(getPath(root.right, target));
        }
        return queue;
    }
}
