package com.example.leetcode.leetcode145;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wzw
 * @date 2024/10/6 19:21
 * @description

 */
public class LeetCode145 {
    public static void main(String[] args) {


    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        //postorder(res,root);
        //return res;
        if (root == null)
            return res;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            res.add(node.val);
            if (node.left != null) {
                deque.push(node.left);
            }
            if (node.right != null) {
                deque.push(node.right);
            }
        }
          //Collections.reverse(res);   // Collections.reverse(res)的返回值是空，它是原地反转列表
        //return res;
        return res.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public void postorder(List<Integer> res, TreeNode root) {
        if (root == null) return;
        postorder(res, root.left);
        postorder(res, root.right);
        res.add(root.val);
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
