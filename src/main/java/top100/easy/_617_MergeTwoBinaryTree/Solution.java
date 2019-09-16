package top100.easy._617_MergeTwoBinaryTree;

import top100.model.TreeNode;
import utils.TreeNode.TreeNodeUtils;

/**
 * @author LinZebin
 * @date 2019-06-04 22:12
 */
public class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        final TreeNode defaultTree1 = TreeNodeUtils.getDefaultTree();
        final TreeNode defaultTree2 = TreeNodeUtils.getDefaultTree();
        Solution s = new Solution();
        s.mergeTrees(defaultTree1,defaultTree2);
    }
}
