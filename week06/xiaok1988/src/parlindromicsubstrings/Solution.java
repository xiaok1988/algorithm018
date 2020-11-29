package parlindromicsubstrings;

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length() + 1; j++) {
                if (isParlidrom(s.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isParlidrom(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        return s.equals(sb.toString());
    }
}
