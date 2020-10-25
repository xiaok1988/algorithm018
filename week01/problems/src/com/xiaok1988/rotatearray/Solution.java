package com.xiaok1988.rotatearray;

public class Solution {
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            rotateOne(nums);
        }
    }
    private void rotateOne(int[] nums) {
        int tail = nums[nums.length - 1];
        System.arraycopy(nums, 0, nums, 1, nums.length - 1);
        nums[0] = tail;
    }
}
