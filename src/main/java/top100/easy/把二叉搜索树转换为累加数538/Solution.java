package top100.easy.把二叉搜索树转换为累加数538;

import top100.model.TreeNode;

/**
 * @author LinZebin
 * @date 2019-09-19 20:45
 */
public class Solution {

    /**
     * 二叉搜索数中序遍历(左-根-右)后是升序排序的，
     * 修改下（右-根-左），则为降序的
     */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        help(root);
        return root;
    }

    /**
     * 按（右-根-左）的循序进行中序遍历，并累加sum值，将当前节点值加上sum
     * @param root
     */
    private void help(TreeNode root){
        if(root == null){
            return;
        }
        help(root.right);
        sum += root.val;
        root.val = sum;
        help(root.left);
    }
}
