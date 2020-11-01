package com.xiaok1988.choushulcof;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int nthUglyNumber(int n) {
        int[] uglies = new int[]{2,3,5};
        Queue<Long> queue = new PriorityQueue<>();
        queue.offer(1L);
        int cnt = 0;
        while(!queue.isEmpty()) {
            long current = queue.poll();
            if (++cnt >= n) {
                return (int) current;
            }
            for (int x : uglies) {
                if (!queue.contains(current * x)) {
                    queue.offer(current *x);
                }
            }

        }
        return 0;
    }
}
