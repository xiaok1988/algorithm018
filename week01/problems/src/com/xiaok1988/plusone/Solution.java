package com.xiaok1988.plusone;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> ans = new ArrayList<>();
        boolean flag = true;
        for (int i = digits.length - 1; i >= 0 ; i--) {
            if (digits[i] < 9 ) {

                if (flag) {
                    ans.add(digits[i] +1);
                } else {
                    ans.add(digits[i]);
                }
                flag = false;

            } else {

                if (flag) {
                    ans.add(0);
                    if (i == 0) {
                        ans.add(1);
                    }
                } else {
                    ans.add(digits[i]);
                }

            }
        }
        int[] finals = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            finals[i] = ans.get(ans.size() - 1 - i);
        }
        return finals;
    }
}
