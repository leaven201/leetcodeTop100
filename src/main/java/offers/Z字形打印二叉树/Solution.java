package offers.Z字形打印二叉树;

import top100.model.TreeNode;
import utils.TreeNode.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author LinZebin
 * @date 2019-05-24 17:29
 */
public class Solution {

    public List<List<Integer>> printFromTopToBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    level.add(node.val);
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                }
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    level.add(node.val);
                    if (node.right != null) {
                        stack1.push(node.right);
                    }
                    if (node.left != null) {
                        stack1.push(node.left);
                    }
                }
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        final List<List<Integer>> lists = s.printFromTopToBottom(TreeNodeUtils.getDefaultTree());
        System.out.println(lists);
    }
}
