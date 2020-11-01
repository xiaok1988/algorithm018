package com.xiaok1988.narytreelevelordertraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Deque<Node> middle = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        middle.push(root);
        while(!middle.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = middle.size();
            for (int i = 0; i < size; i++) {
                Node node = middle.poll();
                level.add(node.val);
                middle.addAll(node.children);
            }
            result.add(level);

        }
        return result;
    }
}
