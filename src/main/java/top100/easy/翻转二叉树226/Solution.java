package top100.easy.翻转二叉树226;

import top100.model.TreeNode;

/**
 * @author LinZebin
 * @date 2019-09-19 20:04
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
