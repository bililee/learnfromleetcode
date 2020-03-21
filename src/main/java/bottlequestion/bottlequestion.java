package bottlequestion;

import java.net.Inet4Address;

public class bottlequestion {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Boolean res = solution.canMeasureWater(Integer.valueOf(args[0]), Integer.valueOf(args[1]) ,Integer.valueOf(args[2]));
        System.out.println(res);

    }
}





class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        Integer max = x > y ? x : y;
        Integer min = x > y ? y : x;
        if ((x+y) < z ) {
            return false;
        }

        if (min == 0) {

            return z == max || z % max == 0;
        }
        while (max % min != 0 ) {
            max = max % min;
            if (max < min) {
                int t = min;
                min = max;
                max = t;
            }
        }
        if (z % min == 0) {
            return true;
        } else {
            return false;
        }
    }
}