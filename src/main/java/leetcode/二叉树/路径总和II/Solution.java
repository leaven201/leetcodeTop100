package leetcode.二叉树.路径总和II;

import top100.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LinZebin
 * @date 2019-09-18 16:58
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(res, path, root, sum);
        return res;
    }

    // 定义：在当前路径为path的基础上，从root出发找出所有路径和为sum的路径加入res
    private void helper(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum){
        // 出口
        if(root == null){
            return;
        }
        // 将当前节点加入path
        path.add(root.val);
        // 当前路径和满足条件 -> 将当前路径加入res，并回退上一节点
        if(root.left == null && root.right == null && root.val == sum){
            res.add(new ArrayList<>(path));
            // 回溯
            path.remove(path.size() - 1);
            return;
        }
        // 当前路径和不满足条件 -> 更新sum值，从左右子树接着找
        helper(res, path, root.left, sum - root.val);
        helper(res, path, root.right, sum - root.val);
        // 回溯
        path.remove(path.size() - 1);
    }
}
