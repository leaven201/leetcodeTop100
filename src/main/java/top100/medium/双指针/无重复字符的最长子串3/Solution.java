package top100.medium.双指针.无重复字符的最长子串3;

import java.util.HashMap;

/**
 * @author LinZebin
 * @date 2019-09-17 21:11
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(right < s.length()){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while(map.getOrDefault(s.charAt(right), 0) > 1){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public int lengthOfLongestSubstringOld(String s) {
        int max = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                int index = map.get(s.charAt(end));
                //这个判断很重要！要保证重复的字是在窗口中
                start = Math.max(start, index + 1);
            }
            map.put(s.charAt(end), end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        final int res = lengthOfLongestSubstring("abcabcbb");
        System.out.println(res);
    }
}
