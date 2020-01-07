package com.company;

import java.util.ArrayList;
import java.util.List;

public class No0009IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));

    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        List<Integer> list = new ArrayList<>();
        int cur = 0;
        while (x > 0){
            cur = x % 10;
            list.add(cur);
            x = x / 10;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right){
            if (list.get(left) != list.get(right))
                return false;
            left++;
            right--;
        }

        return true;
    }
}
