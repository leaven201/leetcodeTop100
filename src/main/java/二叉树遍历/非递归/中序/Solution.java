package 二叉树遍历.非递归.中序;

import top100.model.TreeNode;
import utils.TreeNode.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author LinZebin
 * @date 2019-10-14 19:45
 */
public class Solution {

    /**
     * 1. 申请一个stack，初始时cur = root
     * 2. 把cur压入栈中，对以cur为根的整棵子树而言，不停地将其cur.left压入栈中 cur = cur.left
     * 3. 当cur为空时，弹出stack栈顶节点，记为node，打印node，并让cur=node.right,然后重复2
     * 4. 当stack为空且cur为空时，停止
     * @param root
     * @return
     */
    public static List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }else {
                TreeNode node = stack.pop();
                result.add(node.val);
                cur = node.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.getDefaultTree();
        final List<Integer> res = inorder(root);
        System.out.println(res);
    }
}
