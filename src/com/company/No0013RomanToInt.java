package com.company;

import java.util.HashMap;

public class No0013RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> charToNum = new HashMap<>();
        charToNum.put('I', 1);
        charToNum.put('V', 5);
        charToNum.put('X', 10);
        charToNum.put('L', 50);
        charToNum.put('C', 100);
        charToNum.put('D', 500);
        charToNum.put('M', 1000);

        char[] chars = s.toCharArray();
        int index = chars.length - 1;
        int res = charToNum.get(chars[index]);
        index--;
        while (index >= 0){
            int numCur = charToNum.get(chars[index]);
            int numLat = charToNum.get(chars[index+1]);
            if (numCur >= numLat) res += numCur;
            else res -= numCur;
            index--;
        }

        return res;
    }
}
