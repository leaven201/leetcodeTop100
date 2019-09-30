package 剑指offers.替换空格;

/**
 * @author LinZebin
 * @date 2019-09-30 16:04
 */
public class Solution {
    public static String replaceSpaces(StringBuffer str) {
        StringBuffer res = new StringBuffer();
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i) == ' '){
                res.append("%20");
            }else {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        final String res = replaceSpaces(new StringBuffer("a b c"));
        System.out.println(res);
    }
}
