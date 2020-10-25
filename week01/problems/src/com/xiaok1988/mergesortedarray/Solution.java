package com.xiaok1988.mergesortedarray;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i <nums2.length; i++) {
                nums1[i] = nums2[i];
            }
        }
        if (n == 0) {
            return;
        }
        int[] result = new int[m + n];
        int count = 0;
        int index1 = 0;
        int index2 = 0;
        while (count < m + n && index1 <= m  && index2 <= n) {
            if (index1 < m  && index2 < n&& nums1[index1] < nums2[index2]) {
                result[count] = nums1[index1];
                index1++;
            } else if (index1 < m  && index2 < n && nums1[index1] >= nums2[index2]){
                result[count] = nums2[index2];
                index2++;
            } else if (index1 == m) {
                result[count] = nums2[index2];
                index2++;
            } else if (index2 == n) {
                result[count] = nums1[index1];
                index1++;
            }
            count++;
        }
        for (int i = 0; i <result.length; i++) {
            nums1[i] = result[i];
        }
    }
}
