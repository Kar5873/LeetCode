package com.leetcode.structure.d11;

import com.leetcode.structure.d01_03.MaximumSubArray;
import com.leetcode.structure.d10.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的最大深度
 *
 * @author kar
 * @create 2021-11-30 20:18
 */
public class MaximumDepthOfBinaryTree {
    // 0, 2,4, 1,null,3,-1, 5,1,null,6,null,8
    public static void main(String[] args) {
        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();
        int len = tree.maxDepth(
                    new TreeNode(0
                        ,new TreeNode(2
                            ,new TreeNode(1
                                ,new TreeNode(5)
                                ,new TreeNode(1))
                            ,null)
                        ,new TreeNode(4
                            ,new TreeNode(3
                                ,null
                                ,new TreeNode(6))
                            ,new TreeNode(-1
                                ,null
                                ,new TreeNode(8)))));
        System.out.println(len);
    }

    // 深度优先算法，递归
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }


        // 广度优先算法
    public int maxDepth1(TreeNode root) {
        int lev = 0;
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                lev++;
                int l = queue.size();
                for (int i = 0; i < l; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
        }
        return lev;
    }
}
