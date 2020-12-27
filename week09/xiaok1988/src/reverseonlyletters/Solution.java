package reverseonlyletters;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String reverseOnlyLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        List<Character> letters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                letters.add(s.charAt(i));
            }
        }
        int index = 0;
        int lettersize = letters.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                sb.append(letters.get(lettersize - index - 1));
                index++;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }
}
