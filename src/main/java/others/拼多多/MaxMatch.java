package others.拼多多;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LinZebin
 * @date 2019-08-10 19:32
 */
public class MaxMatch {
    public static int maxMatch(int[] persons){
        Arrays.sort(persons);
        int match = 0;
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = i+1; j < persons.length; j++) {
                if (persons[i] >= 0.9 * persons[j]) {
                    match++;
                }else{
                    break;
                }
            }
        }
        return match;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] persons = new int[N];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = in.nextInt();
        }

        Arrays.sort(persons);
        int match = 0;
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = i+1; j < persons.length; j++) {
                if (persons[i] >= 0.9 * persons[j]) {
                    match++;
                }else{
                    break;
                }
            }
        }
        System.out.println(match);
    }

}
