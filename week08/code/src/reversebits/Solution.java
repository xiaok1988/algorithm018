package reversebits;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String origianl = Integer.toBinaryString(n);
        if (origianl.length() < 32) {
            int diff = 32 - origianl.length();
            for (int i = 0; i < diff; i++) {
                origianl = "0" + origianl;
            }
        }
        String transformed = new StringBuffer(origianl).reverse().toString();
        int res = 0;
        for (int i = 0; i < transformed.length(); i++) {
            char cur = transformed.charAt(i);
            res = res * 2 + cur - '0';
        }
        return res;
    }
}
