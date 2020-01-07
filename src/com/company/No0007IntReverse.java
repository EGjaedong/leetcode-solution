package com.company;

import java.util.ArrayList;
import java.util.List;

public class No0007IntReverse {
    public static int reverse(int x) {
        boolean isNegative = false;
        if (x < 0){
            isNegative = true;
            x = Math.abs(x);
        }

        List<Integer> list = new ArrayList<>();
        int curNum = 0;
        while (x > 0){
            curNum = x % 10;
            list.add(curNum);
            x = x/10;
        }

        long result = 0;

        for (Integer cur : list) {
            result = result * 10 + cur;
        }

        if (isNegative){
            result = result * (-1);
            if (result < Integer.MIN_VALUE)
                return 0;
        }
        else {
            if (result > Integer.MAX_VALUE)
                return 0;
        }

        return (int)result;
    }

    public static void main(String[] args) {
        int res = reverse(1534236469);
        System.out.println(res);
    }
}
