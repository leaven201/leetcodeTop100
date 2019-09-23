package top100.easy.路径总和III437;

import top100.model.TreeNode;

import java.util.HashMap;

/**
 * @author LinZebin
 * @date 2019-09-19 21:20
 */
public class Solution {

    /**
     * 全局变量，统计和为sum的路径数
     */
    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> sumMap = new HashMap();
        sumMap.put(0, 1);
        dfs(root, sum, 0, sumMap);
        return count;
    }

    /**
     * 找出以node为根结点，路径和为sum的路径数
     * @param node 根结点
     * @param sum 路径和
     * @param preSum 之前的路径和
     * @param sumMap 出现次数（key:路径和 value：出现次数）
     */
    private void dfs(TreeNode node, int sum, int preSum, HashMap<Integer, Integer> sumMap) {
        //利用前序遍历的顺序--所以先操作node，再去遍历node的左右子树
        if (node == null) {
            return;
        }
        int curSum = preSum + node.val;
        //先更新count再将curSum加入sumMap
        if (sumMap.containsKey(curSum - sum)) {
            count += sumMap.get(curSum - sum);
        }
        //将curSum加入sumMap
        sumMap.put(curSum, sumMap.getOrDefault(curSum, 0) + 1);
        //遍历左右子树
        dfs(node.left, sum, curSum, sumMap);
        dfs(node.right, sum, curSum, sumMap);
        //此时遍历完了左右子树，要返回node,所以要删掉sumMap中此时添加的curSum
        sumMap.put(curSum, sumMap.get(curSum) - 1);
    }

}
