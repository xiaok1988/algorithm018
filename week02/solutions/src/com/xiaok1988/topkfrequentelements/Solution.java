package com.xiaok1988.topkfrequentelements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Node {
    int val;
    int cnt;
    public Node(int val, int cnt) {
        this.val = val;
        this.cnt = cnt;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Node> nodes = new ArrayList<Node>();
        int[] res = new int[k];
        for (int i = 0; i < nums.length; i++) {
            boolean exist = false;
            for (Node node : nodes) {
                if (node.val == nums[i]) {
                    node.cnt++;
                    exist = true;
                }
            }
            if (!exist) {
                Node node = new Node(nums[i], 1);
                nodes.add(node);
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(nodes.size(), new Comparator<Node>(){
            public int compare(Node node1, Node node2) {
                return node2.cnt - node1.cnt;
            }
        });
        for (int i = 0; i < nodes.size(); i++) {
            queue.add(nodes.get(i));
        }
        for (int i = 0; i < k ; i++) {
            Node node = queue.poll();
            res[i] = node.val;
        }
        return res;
    }
}
