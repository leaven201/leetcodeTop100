package top100.easy._101_SymmetricTree;


import org.junit.Test;
import top100.utils.TreeNode;

import java.util.*;
import java.util.Map.Entry;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root.left,root.right);
    }
    //判断两棵树是否是对称的树
    //两棵树对称：
    //1.根节点一样Tree1、Tree2
    //2.Tree1.left和Tree2.right 且 Tree1.right和Tree2.left都是对称树
    private boolean isMirror(TreeNode left, TreeNode right){
        //都为null时说明对称
        if(left == null && right == null){
            return true;
        }
        //一个是null，一个不为null时说明不对称
        if(left == null || right == null){
            return false;
        }
        //此时说明都不为null
        if(left.val != right.val){
            return false;
        }
        return isMirror(left.right,right.left) && isMirror(left.left,right.right);
    }

    private int minCount(int n,int[] powers, int[] money){
        int cost = 0;
        int power = 0;

        TreeMap<Double,Integer> map = new TreeMap<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return -o1.compareTo(o2);
            }
        });
        double[] value = new double[powers.length];
        for(int i=0;i<powers.length;i++){

        }
        for (int i=0;i<powers.length;i++){
            map.put((double) (powers[i]/money[i]),i);
            if(power < powers[i]){
                Entry<Double,Integer> en = map.firstEntry();
                Double key = en.getKey();
                int val = en.getValue();
                power += powers[val];
                cost += money[val];
                map.remove(key);
            }
        }
        return cost;
    }
    @Test
    public void test(){
        int[] powers = {1,2,4,8};
        int[] money = {1,2,1,2};
        int res = minCount(4,powers,money);
        System.out.println(res);
    }
}
