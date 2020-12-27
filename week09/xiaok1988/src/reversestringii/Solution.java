package reversestringii;

class Solution {
    public String reverseStr(String s, int k) {
        int length = s.length();
        int num = length / (2 * k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < k ;j++) {
                sb.append(s.charAt(2 * k * i + k - j - 1));
            }
            for (int j = 0; j < k;j ++) {
                sb.append(s.charAt(2 * k * i + k + j));
            }
        }
        int mod = length - 2 * k * num;
        if (mod >= k) {
            for(int j = 0; j < k ; j++) {
                sb.append(s.charAt(2 * k * num + k - j - 1));
            }
            for (int j = 0; j < mod - k; j++) {
                sb.append(s.charAt(2 * k * num + k + j));
            }
        } else {
            for (int j = 0; j < mod; j++) {
                sb.append(s.charAt(s.length() - j - 1));
            }
        }
        return sb.toString();
    }
}
