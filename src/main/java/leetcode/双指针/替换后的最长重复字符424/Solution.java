package leetcode.双指针.替换后的最长重复字符424;

/**
 * @author LinZebin
 * @date 2019-09-17 16:29
 */
public class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0){
            return 0;
        }
        // 滑动窗口开始、结束游标
        int start = 0;
        int end = 0;
        // 统计窗口每个字母出现次数
        int[] times = new int[26];
        // 初始化，第一个字母出现次数为1
        times[s.charAt(0) - 'A'] = 1;
        // 结果（最长重复数）
        int res = 1;
        while (end < s.length()){
            // 1.扩大窗口
            while (k >= end - start + 1 - getMaxTime(times)){
                res = Math.max(res, end - start +1);
                end++;
                if (end < s.length()){
                    times[s.charAt(end) - 'A']++;
                }else {
                    break;
                }
            }
            // 2.缩小窗口
            times[s.charAt(start) - 'A']--;
            start++;
        }
        return res;
    }

    private int getMaxTime(int[] times) {
        int max = 0;
        for (int time : times) {
            max = Math.max(time, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "AAAA";
        final int res = solution.characterReplacement(s, 1);
        System.out.println(res);
    }
}
