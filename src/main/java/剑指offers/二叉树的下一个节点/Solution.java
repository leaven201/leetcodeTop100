package 剑指offers.二叉树的下一个节点;


import top100.model.TreeNode;

/**
 * @author LinZebin
 * @date 2019-09-16 15:25
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode node) {
        if (node == null){
            return null;
        }
        // 1.如果存在右子节点，则下一节点为右子节点的最左节点
        if (node.right != null){
            node = node.right;
            while (node.left != null){
                node = node.left;
            }
            return node;
        }

        // 2.如果没有右子节点，则向上找第一个是父节点的左子节点的节点
        while (node.father != null){
            if (node.father.left == node){
                return node.father;
            }
            node = node.father;
        }
        return null;
    }

}
