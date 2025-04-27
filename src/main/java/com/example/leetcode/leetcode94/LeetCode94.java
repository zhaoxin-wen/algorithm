package com.example.leetcode.leetcode94;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wzw
 * @date 2024/10/6 19:28
 * @description

 */
public class LeetCode94 {
    public static void main(String[] args) {

    }


    public List<Integer> inorderTraversal1(TreeNode root) {

        Deque<Integer> deque = new LinkedList<>();
        while (root!=null){
            root = root.left;

        }

        return null;

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(res, root);
        return res;
    }

    public void inorder(List<Integer> res, TreeNode root) {
        if (root == null) return;
        inorder(res, root.left);
        res.add(root.val);
        inorder(res, root.right);
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
