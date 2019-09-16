package others.拼多多;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LinZebin
 * @date 2019-07-28 15:05
 */
public class Solution {

    public int[] findRise(int[] A, int[] B) {
        Integer wrongIndex = findWroingIndex(A);
        //A已经排好序
        if (wrongIndex == null){
            wrongIndex = A.length -1;
        }
        Arrays.sort(B);
        // 第一个数就错
        if (wrongIndex == 0) {
            int bigger = A[1];
            for (int i = B.length - 1; i > 0; i--) {
                if (B[i] < bigger) {
                    A[i] = B[i];
                    return A;
                }
            }
        }
        // 最后一个错
        else if (wrongIndex == A.length - 1) {
            int bigger = A[wrongIndex - 1];
            for (int i = B.length - 1; i > 0; i--) {
                if (B[i] > bigger) {
                    A[wrongIndex] = B[i];
                    return A;
                }
            }
        } else {
            int smaller = A[wrongIndex - 1];
            int bigger = A[wrongIndex + 1];
            for (int i = B.length - 1; i >= 0; i--) {
                if (B[i] > smaller && B[i] < bigger) {
                    A[wrongIndex] = B[i];
                    return A;
                }
            }
        }
        return null;
    }

    // 找出错误的下标
    private Integer findWroingIndex(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= max) {
                return i;
            }
            if (A[i] > max) {
                max = A[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputA = in.nextLine();
        String[] stringA = inputA.split(" ");
        int[] A = new int[stringA.length];
        for (int i = 0; i < stringA.length; i++) {
            A[i] = Integer.valueOf(stringA[i]);
        }
        String inputB = in.nextLine();
        String[] stringB = inputB.split(" ");
        int[] B = new int[stringB.length];
        for (int i = 0; i < stringB.length; i++) {
            B[i] = Integer.valueOf(stringB[i]);
        }
        Solution s = new Solution();
        int[] rise = s.findRise(A, B);
        if (rise == null) {
            System.out.println("NO");
        } else {
            String s1 = Arrays.toString(rise);
            final String replace = s1.replace(",", "");
            System.out.println(replace);
        }
    }


}
