package top100.hard.双指针.最小覆盖子串76;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LinZebin
 * @date 2019-09-17 21:16
 */
public class Solution {
    /**
     * 思路：滑动窗口left、right定义窗口左右边界
     * right:扩大窗口，当diff>0时，right++直到diff==0
     * left:收缩窗口，当diff==0时，left++直到diff>0
     * minWindow:记录满足条件的最小窗口，每当diff==0(满足条件),判断是否需要更新
     */
    public String minWindow(String s, String t) {
        String minWindow = "";
        if(s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()){
            return minWindow;
        }
        int left = 0;
        int right = 0;
        int diff = t.length();
        // 记录t中各字母及其出现次数
        Map<Character, Integer> tMap = new HashMap<>();
        for (Character ch : t.toCharArray()) {
            int times = tMap.getOrDefault(ch, 0);
            tMap.put(ch, times + 1);
        }
        // 记录窗口中属于t的字母及其出现次数
        Map<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            // 当diff>0时，向前移动right，扩大window
            while (right < s.length() && diff > 0) {
                char cur = s.charAt(right);
                // cur是t中的字母
                if (tMap.containsKey(cur)) {
                    // 判断是否需要更新diff
                    int times = window.getOrDefault(cur, 0);
                    // 如果window中cur出现的次数小于tMap中cur出现的次数，则diff--
                    if (times < tMap.get(cur)) {
                        diff--;
                    }
                    // 更新window中cur出现的次数(重要！不能写time++)
                    window.put(cur, times + 1);
                }
                right++;
            }
            // 此时说明right越界或者diff==0
            while (left <= right && diff == 0) {
                if (minWindow.equals("") || right - left < minWindow.length()) {
                    minWindow = s.substring(left, right);
                }
                char leftChar = s.charAt(left);
                if (tMap.containsKey(leftChar)) {
                    int times = window.get(leftChar);
                    if (times <= tMap.get(leftChar)) {
                        diff++;
                    }
                    // (重要！不能写time--)
                    window.put(leftChar, times - 1);
                }
                left++;
            }
        }
        return minWindow;
    }


    public static String minWindow1(String s, String t) {
        String res = "";
        if(s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()){
            return res;
        }
        int left = 0;
        int right = 0;
        // 窗口子字符串和t的的差异数
        int diff = t.length();
        // 记录t中各字母出现的次数
        Map<Character, Integer> tMap = new HashMap<>(diff);
        for(int i=0; i<t.length(); i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>(diff);
        while(right < s.length()){
            char cur = s.charAt(right);
            if(tMap.containsKey(cur)){
                int times = window.getOrDefault(cur, 0);
                if(times < tMap.get(cur)){
                    diff--;
                }
                window.put(cur, times + 1);
            }
            // 缩小窗口
            while(diff == 0 && left < s.length()){
                // 判断是否更新res
                if(res.equals("") || res.length() > right - left + 1){
                    res = s.substring(left, right + 1);
                }
                // 判断从窗口中剔除的数是否属于t
                if(tMap.containsKey(s.charAt(left))){
                    //判断剔除后会对diff有影响
                    if(window.get(s.charAt(left)) <= tMap.get(s.charAt(left))){
                        diff++;
                    }
                    window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                }
                left++;
            }
            // 扩大窗口
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        final String res = minWindow1("ADOBECODEBANC", "ABC");
        System.out.println(res);

    }


}
