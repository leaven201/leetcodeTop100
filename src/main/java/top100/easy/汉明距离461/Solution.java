package top100.easy.汉明距离461;

/**
 * @author LinZebin
 * @date 2019-09-19 20:00
 */
public class Solution {
    //汉明距：00-0 11-0 10-1 01-1 即异或操作
    //等价于求x^y后有多少个1
    public int hammingDistance(int x, int y) {
        int OR = x ^ y;
        int distance = 0;
        while(OR != 0){
            distance++;
            //x & x-1 相当于把x的最后一位的1置0
            OR = OR & (OR - 1);
        }
        return distance;
    }
}
