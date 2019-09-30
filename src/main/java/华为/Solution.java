package 华为;


import java.util.Scanner;

/**
 * @author LinZebin
 * @date 2019-09-25 19:06
 */
public class Solution  {

    public static String[] startArr = {"*", "**", "***","****","*****","******","*******","********","*********","**********"};
    private static String func(String str, String rep){
        if (str == null || rep == null) {
            return str;
        }
        String startChar = getStartChar(rep.length());
        return str.replace(rep, startChar);
    }

    private static String getStartChar(int length) {
        if (length <= 0){
            return "";
        }
        if (length <= 10){
            return startArr[length - 1];
        }
        char[] arr = new char[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = '*';
        }
        return new String(arr);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String s = sc.nextLine();
        final String[] s1 = s.split(" ");
        final String res = func(s1[0], s1[1]);
        System.out.println(res);

    }

}
