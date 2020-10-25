package com.xiaok1988.movezeroes;

public class Solution {
    public void moveZeroes(int[] nums) {
        int lastIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastIndex++] = nums[i];
            }
        }
        for (int i = lastIndex; i <nums.length; i++) {
            nums[i] = 0;
        }
    }
}
