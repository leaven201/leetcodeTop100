package top100.easy.二叉树的最大深度104;

import top100.model.TreeNode;

/**
 * @author LinZebin
 * @date 2019-09-19 20:10
 */
public class Solution {
    // 方法定义：返回一棵二叉树的最大深度
    public int maxDepth(TreeNode root) {
        // 出口
        if(root == null){
            return 0;
        }
        // divide
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // conque
        return Math.max(left, right) + 1;
    }
}
