package xiaok1988.assigncookies;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (s == null || s.length == 0) {
            return 0;
        }
        if (g == null || g.length == 0) {
            return 0;
        }
        Arrays.sort(s);
        Arrays.sort(g);
        int index = 0;
        int res = 0;
        for (int i = 0; i < g.length; i++) {
            if (index > s.length - 1) {
                break;
            }
            if (g[i] <= s[index]) {
                res++;
                index++;
            } else {
                while(g[i] > s[index]) {
                    index++;
                    if (index > s.length - 1) {
                        break;
                    }
                }
                if (index <= s.length - 1) {
                    res++;
                    index++;
                }


            }


        }
        return res;
    }
}