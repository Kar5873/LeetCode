package com.leetcode.structure.d12;

import com.leetcode.structure.d10.TreeNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2、路径总和
 * <p>
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 *
 * @author Kar
 * @create 2021-12-01 下午1:40
 */
public class PathSum {
    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        pathSum.hasPathSum(new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))), 22);
    }

    // 递归
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null){
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


    // 迭代
    // 逐层计算路径和
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root != null) {
            // 存放每层的节点
            Queue<TreeNode> preNode = new LinkedList();
            // 存放每层各个节点的路径和
            Queue<Integer> stackVal = new LinkedList<>();
            preNode.offer(root);
            stackVal.offer(root.val);
            while (!preNode.isEmpty()) {
                TreeNode node = preNode.poll();
                int tmpVal = stackVal.poll();
                // 到达叶子节点时判断
                if (node.left == null && node.right == null) {
                    if (tmpVal == targetSum) {
                        return true;
                    }
                }
                if (node.left != null) {
                    preNode.offer(node.left);
                    stackVal.offer(tmpVal + node.left.val);
                }
                if (node.right != null) {
                    preNode.offer(node.right);
                    stackVal.offer(node.right.val + tmpVal);
                }
            }
        }
        return false;
    }



}
