package 二叉树遍历.非递归.前序;

import top100.model.TreeNode;
import utils.TreeNode.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author LinZebin
 * @date 2019-10-14 19:25
 */
public class Solution {

    /**
     * 1.申请stack，将根结点root压入栈中
     * 2.从stack中弹出栈顶节点，记为cur，并打印cur，先cur.right如果非空则入栈，再cur.left如果非空则入栈
     * 3.不断重复2知道stack为空
     * @param root
     * @return
     */
    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.right != null) {
                stack.add(cur.right);
            }
            if (cur.left != null) {
                stack.add(cur.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.getDefaultTree();
        final List<Integer> res = preOrder(root);
        System.out.println(res);
    }

}
