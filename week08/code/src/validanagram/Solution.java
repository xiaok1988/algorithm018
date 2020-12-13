package validanagram;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] src = new int[26];
        int[] tgt = new int[26];
        for (int i = 0; i < s.length(); i++){
            char pointSrc = s.charAt(i);
            src[pointSrc - 'a']++;
            char pointTgt = t.charAt(i);
            tgt[pointTgt - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (src[i] != tgt[i]) {
                return false;
            }
        }
        return true;
    }
}
