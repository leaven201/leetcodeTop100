package 二叉树遍历.非递归.后序;

import top100.model.TreeNode;
import utils.TreeNode.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author LinZebin
 * @date 2019-10-14 19:24
 */
public class Solution {

    /**
     * 1. 申请一个stack1，然后将root压入stack1
     * 2. 从stack1弹出的节点记为cur，然后依次将cur的左右孩子压入stack1
     * 3. 在整个过程中，每一个从stack1弹出的节点都放入stack2中
     * 4. 不断重复2，3，直到stack1为空，则停止
     * 5. 依次弹出stack元素就是后序遍历
     * @param root
     * @return
     */
    public static List<Integer> posOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);
        while (!stack1.isEmpty()) {
            TreeNode cur = stack1.pop();
            stack2.add(cur);
            if (cur.left != null) {
                stack1.add(cur.left);
            }
            if (cur.right != null) {
                stack1.add(cur.right);
            }
        }
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }
        return result;
    }

    public static void main(String[] args) {
        final TreeNode root = TreeNodeUtils.getDefaultTree();
        final List<Integer> res = posOrder(root);
        System.out.println(res);
    }
}
