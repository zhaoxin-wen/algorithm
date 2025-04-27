package com.example.leetcode.leetcode102;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wzw
 * @date 2024/10/8 16:32
 * @description

 */
public class LeetCode102 {
    public static void main(String[] args) {
        
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.offer(root);
        while(!deque.isEmpty()){
            List<Integer> itemList = new ArrayList<Integer>();
            int len =deque.size();
            while (len > 0){
                TreeNode node = deque.poll();
                itemList.add(node.val);
                if(node.left != null){
                    deque.offer(node.left);
                }
                if(node.right != null){
                    deque.offer(node.right);
                }
                len--;
            }
            res.add(itemList);
        }
        return res;

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
