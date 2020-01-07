package com.company;

import java.util.*;

/**
 *
 */
public class No0003LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring3(" "));
    }

    // 优化后的滑动窗口 O(n)
    public static int lengthOfLongestSubstring3(String s){
        int n = s.length();
        // 定义一个map，第一个存字符，第二个存对应的索引
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, max = 0;
        for (; j < n; j++){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }
            max = Math.max(max, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return max;
    }

    // 滑动窗口，时间复杂度O(n)。最坏O(2n)：bbbbbb，这种，所有元素都要过两遍
    public static int lengthOfLongestSubstring2(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int max = 0, i = 0, j = 0;
        while (i < n && j < n){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }


    //  时间复杂度为 O(n^2)
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;

        char[] chars = s.toCharArray();

        List<Character> maxLengthStr = new LinkedList<>();
        maxLengthStr.add(chars[0]);
        List<Character> curStr = new LinkedList<>();
        curStr.add(chars[0]);

        int right = 1;
        while (right < chars.length){
            if (curStr.contains(chars[right])){
                if (chars[right] == curStr.get(curStr.size()-1)){

                    curStr.clear();
                    curStr.add(chars[right]);
                    maxLengthStr = maxLengthStr.size() >= curStr.size()? maxLengthStr: new LinkedList<>(curStr);
                }
                else {

                    int index = curStr.indexOf(chars[right]);
                    for (int i = 0; i <= index; i++){
                        curStr.remove(curStr.get(0));
                    }
                    curStr.add(chars[right]);
                    maxLengthStr = maxLengthStr.size() >= curStr.size()? maxLengthStr: new LinkedList<>(curStr);
                }
            }
            else {
                curStr.add(chars[right]);
                maxLengthStr = maxLengthStr.size() >= curStr.size()? maxLengthStr: new LinkedList<>(curStr);
            }
            right++;
        }
        maxLengthStr = maxLengthStr.size() >= curStr.size()? maxLengthStr: curStr;

        return maxLengthStr.size();
    }
}
