package firstuniquecharacterinastring;

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (countMap.containsKey(ch)) {
                countMap.put(ch, countMap.get(ch) + 1);
            } else {
                countMap.put(ch, 1);
            }
        }
        int index = Integer.MAX_VALUE;
        for (Character ch : countMap.keySet()) {
            if (countMap.get(ch) == 1) {
                int cur = s.indexOf(ch);
                if (cur < index) {
                    index = cur;
                }
            }
        }
        if (index == Integer.MAX_VALUE) {
            return -1;
        }
        return index;
    }
}
