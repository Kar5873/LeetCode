package com.leetcode.structure.d14;

import com.leetcode.structure.d10.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 验证二叉搜索树
 * <p>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @author Kar
 * @create 2021-12-03 下午3:43
 */
public class ValidateBinarySearchTree {
    // [5,4,6,null,null,3,7]
    public static void main(String[] args) {
        ValidateBinarySearchTree tree = new ValidateBinarySearchTree();
        tree.isValidBST(new TreeNode(5, new TreeNode(4, null, null), new TreeNode(6, new TreeNode(3), new TreeNode(7))));
    }

    // 递归
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    //中序遍历
    public boolean isValidBST1(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        long limit = Long.MIN_VALUE;
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.poll();
            if (root.val <= limit){
                return false;
            }
            limit = root.val;
            root=root.right;
        }
        return true;
    }


    }
