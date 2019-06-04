package others.PhoneNumGenerator;

/**
 * @author LinZebin
 * @date 2019-06-01 14:27
 */
public class Solution {

    int sum = 0;

    public void phoneGenerator(int n) {
        for (int i = 1; i < 10; i++) {
            helper(String.valueOf(i), n);
        }
    }

    //定义：打印以prefix开头的所有满足条件的phoneNumbers
    private void helper(String prefix, int n) {
        if (sum >= n) {
            return;
        }
        if (prefix.length() == 10) {
            String reg = "(\\d{3})(\\d{3})(\\d{4})";
            String resPlace = "$1-$2-$3";
            String res = prefix.replaceAll(reg, resPlace);
            System.out.println(res);
            sum++;
            return;
        }
        for (int i = 0; i < 10; i++) {
            helper(prefix + i, n);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.phoneGenerator(11);
    }
}
