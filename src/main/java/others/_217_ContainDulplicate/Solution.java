package others._217_ContainDulplicate;

import java.util.HashSet;

/**
 * @author LinZebin
 * @date 2019-04-15 20:28
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

}
