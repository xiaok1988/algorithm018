package reversewordsinastring;

import java.util.Arrays;
import java.util.List;

class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split("\\s+");
        List<String> list = Arrays.asList(strs);
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i).trim()).append(" ");
        }

        return sb.toString().trim();
    }
}
