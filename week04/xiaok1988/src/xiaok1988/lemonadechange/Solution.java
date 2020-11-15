package xiaok1988.lemonadechange;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return true;
        }
        int five_dollers = 0;
        int ten_doccers = 0;
        for (int i = 0; i < bills.length ; i++) {
            if (bills[i] == 5) {
                five_dollers++;
            } else if (bills[i] == 10) {
                ten_doccers++;
                five_dollers--;
            } else {
                if (ten_doccers > 0) {
                    ten_doccers--;
                    five_dollers--;
                } else {
                    five_dollers = five_dollers - 3;
                }
            }
            if (five_dollers < 0 || ten_doccers < 0) {
                return false;
            }
        }
        return true;
    }
}
