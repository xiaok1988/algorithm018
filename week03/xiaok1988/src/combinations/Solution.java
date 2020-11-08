package combinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || n < k) {
            return result;
        }
        List<Integer> tempList = new ArrayList<Integer>();
        backtrack(result, n, k, 1, tempList);
        return result;
    }

    private void backtrack(List<List<Integer>> list, int n, int k, int start, List<Integer> tempList) {
        if (tempList.size() == k) {
            List<Integer> temp = new ArrayList<>(tempList);
            Collections.sort(temp);
            if (!list.contains(temp)) {
                list.add(temp);
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            tempList.add(i);
            backtrack(list, n, k, i + 1, tempList);
            tempList.remove(tempList.size() - 1);
        }


    }
}
