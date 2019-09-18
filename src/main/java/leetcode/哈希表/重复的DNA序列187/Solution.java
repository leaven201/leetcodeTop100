package leetcode.哈希表.重复的DNA序列187;

import java.util.*;

/**
 * @author LinZebin
 * @date 2019-09-18 12:12
 */
public class Solution {

    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        int left = 0;
        int right = left + 10;
        while (right <= s.length()) {
            String subStr = s.substring(left, right);
            int times = map.getOrDefault(subStr, 0);
            map.put(subStr, ++times);
            if (times > 1) {
                set.add(subStr);
            }
            left++;
            right++;
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        final List<String> res = findRepeatedDnaSequences("AAAAAAAAAAA");
        System.out.println(res);
    }
}
