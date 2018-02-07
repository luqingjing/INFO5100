package Assignment3;

import java.util.*;

public class LongestSubstring {

    // Time Complexity : O(n)
    // Space Complexity: O(min(m,n))
    public int lengthOfLongestSubstring(String s) {

        int length = 0;
        // The space required is upper bounded by the size of the charset m and the size of the string n,
        // so the space complexity here is O(min(m,n)).
        HashMap map = new HashMap();

        // An n loop is used, index j will iterate n times. The time complexity here is O(n).
        for(int i = 0, j = 0; j < s.length(); j++) {

            if (map.containsKey(s.charAt(j))) {

                i = Math.max((int)map.get(s.charAt(j)) + 1,i);
            }
            map.put(s.charAt(j),j);
            length = Math.max(length, j - i + 1);
        }
        return length;
    }

    public static void main(String[] args) {

        LongestSubstring longestSubstring = new LongestSubstring();
        String s = "pwwkew";
//        String s = "abcabcbb";
//        String s = "bbbbb";
        int length = longestSubstring.lengthOfLongestSubstring(s);

        System.out.println("Given " + "'" + s + "'" + ", the length of the longest substring is " + length);
    }
}
