package 京东;

import java.util.*;

public class Solution {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        while (in.hasNext()){
            names.add(in.nextLine());
        }
        Map<String, Integer> xingTimes = new HashMap<>();
        for (String name : names) {
            String[] s = name.split(" ");
            if (xingTimes.containsKey(s[0])) {
                xingTimes.put(s[0], xingTimes.get(s[0]) + 1);
            }else {
                xingTimes.put(s[0], 1);
            }
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (String s : xingTimes.keySet()) {
            set.add(xingTimes.get(s));
        }
        int[] times = new int[set.size()];
        int index = times.length - 1;
        for (Integer t : set) {
            times[index] = t;
            index--;
        }
        for (int time : times) {
            for (String name : names) {
                String key = name.split(" ")[0];
                if (xingTimes.get(key) == time) {
                    System.out.println(name);
                }
            }
        }
    }

}
