package mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                return e1[0] - e2[0];
            }
        });
        int[][] res = new int[intervals.length][2];
        if (intervals.length == 0) {
            return new int[0][2];
        }
        int[] temp = new int[2];
        int current = 0;
        temp[0] = intervals[0][0];
        temp[1] = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= temp[1]) {
                if (intervals[i][1] < temp[1]) {
                    //donothing
                } else {
                    temp[1] = intervals[i][1];
                }


            } else {
                res[current][0] = temp[0];
                res[current][1] = temp[1];
                current++;
                temp[0] = intervals[i][0];
                temp[1] = intervals[i][1];
            }
        }
        res[current][0] = temp[0];
        res[current][1] = temp[1];
        int[][] finals = new int[current + 1][2];
        for (int i = 0; i <= current; i++) {
            finals[i][0] = res[i][0];
            finals[i][1] = res[i][1];
        }
        return finals;
    }
}
