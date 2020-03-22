package additionalnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int minIncrementForUnique(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        Integer[] a = new Integer[A.length];
        for (int i = 0; i< A.length; i++) {
            a[i] = A[i];
        }
        MyConoarator cmp = new MyConoarator();
        Arrays.sort(a, cmp);
        // 处理下
        int min = a[0];
        int maxDistance = (a.length + 1) * 2;
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] - min;
        }
        ArrayList capacity = new ArrayList<Integer>();
        ArrayList chongfu = new ArrayList<Integer>();
        int step = 0;
        int count = 0;
        for (int dis = 0 ; dis <= maxDistance + 1; dis ++) {
            if (step >= a.length) {
                capacity.add(dis);
                continue;
            }
            while (a[step] == dis) {
                if (count == 0) {
                    count ++;
                    step ++;
                    if (step >= a.length) {
                        break;
                    }
                    continue;
                }
                chongfu.add(a[step]);
                step ++;
                if (step >= a.length) {
                    break;
                }
                continue;
            }
            if (count == 0) {
                capacity.add(dis);
            } else {
                count = 0;
            }
        }
        int bushu = 0;
        for (Object i : chongfu) {
            int temp = (Integer) i;
            for (int j = 0; j < capacity.size(); j ++) {

                Integer tj = Integer.valueOf(capacity.get(j).toString());
                if (tj >= temp) {
                    bushu += tj - temp;
                    capacity.remove(tj);
                    break;
                }
//                Integer tj2 = Integer.valueOf(capacity.get(j+1).toString());
//                if ( tj < temp
//                        &&
//                        tj2 > temp
//                ) {
//                    if ((temp - tj) <= (tj2 -temp)) {
//                        capacity.remove(capacity.get(j));
//                        bushu += temp - tj;
//                    }
//                    if ((temp - tj) > (tj2 -temp)) {
//                        capacity.remove(capacity.get(j+1));
//                        bushu += tj2 - temp;
//                    }
//                    break;
//                }
            }
        }

        return bushu;
    }
}

class MyConoarator implements Comparator<Integer> {
    public int compare(Integer o1, Integer o2) {
        if (o1 < o2) {
            return -1;
        } else if (o1 > o2) {
            return 1;
        } else {
            return 0;
        }
    }
}