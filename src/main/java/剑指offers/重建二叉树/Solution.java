package 剑指offers.重建二叉树;

import top100.model.TreeNode;

/**
 * @author LinZebin
 * @date 2019-09-30 18:57
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 根据前序遍历和中续遍历重建二叉树
     *
     * @param preorder 前序遍历序列
     * @param preStart 前序遍历开始index
     * @param preEnd 前序遍历结束index
     * @param inorder 中序遍历序列
     * @param inStart 中序遍历开始index
     * @param inEnd 中序遍历结束index
     * @return 重建好的二叉树的根结点
     */
    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        // 出口
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        int inIndex = findIndexInInorder(preorder[preStart], inorder, inStart, inEnd);
        node.left = helper(preorder, preStart + 1, inIndex + preStart - inStart, inorder, inStart, inIndex - 1);
        node.right = helper(preorder, inIndex + preStart - inStart + 1, preEnd, inorder, inIndex + 1, inEnd);
        return node;
    }

    /**
     * 在中序遍历序列中找出nodeVal节点所在位置下标
     *
     * @param nodeVal 寻找的节点
     * @param inorder 中序遍历序列
     * @param start 开始index
     * @param end 结束index
     */
    private int findIndexInInorder(int nodeVal, int[] inorder, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == nodeVal) {
                return i;
            }
        }
        return -1;
    }

}
