package com.example.leetcode.leetcode144;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wzw
 * @date 2024/10/6 19:21
 * @description

 */
public class LeetCode144 {
    public static void main(String[] args) {


    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        //preorder(res, root);
        //return res;
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            res.add(node.val);
            if (node.right != null) {
                deque.push(node.right);
            }
            if (node.left != null) {
                deque.push(node.left);
            }
        }
        return res;

    }

    public void preorder(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(res, root.left);
        preorder(res, root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {

    }
}
