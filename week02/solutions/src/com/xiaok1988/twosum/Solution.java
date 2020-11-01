package com.xiaok1988.twosum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                ans[0] = i;
                ans[1] = hash.get(nums[i]);
                if (ans[0] > ans[1]) {
                    int temp = ans[0];
                    ans[0] = ans[1];
                    ans[1] = temp;
                }
                return ans;
            } else {
                hash.put(target - nums[i], i);
            }
        }
        return ans;
    }
}

