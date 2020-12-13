package relativesortarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        boolean[] hit = new boolean[arr1.length];

        List<Integer> unfound = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            int cur = arr2[i];
            for (int j = 0; j < arr1.length; j++) {
                if (cur == arr1[j]) {
                    res[index] = cur;
                    hit[j] = true;
                    index++;
                }
            }
        }
        for (int i = 0; i < hit.length; i++) {
            if (!hit[i]) {
                unfound.add(arr1[i]);
            }
        }
        Collections.sort(unfound);
        for (int e : unfound) {
            res[index++] = e;
        }
        return res;
    }
}

