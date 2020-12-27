package reversewordsinastringiii;

class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< strs.length; i++) {
            sb.append(new StringBuilder(strs[i]).reverse()).append(" ");
        }
        return sb.toString().trim();

    }
}
