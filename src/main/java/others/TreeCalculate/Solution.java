package others.TreeCalculate;

/**
 * @author LinZebin
 * @date 2019-06-02 10:20
 */
public class Solution {

    public static class TreeNode {

        String val;
        TreeNode left;
        TreeNode right;

        TreeNode(String x) {
            val = x;
        }
    }

    //递归
    public static double calculate(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (!root.val.equals("+")
            && !root.val.equals("-")
            && !root.val.equals("*")
            && !root.val.equals("/")) {
            return (double) Integer.parseInt(root.val);
        }

        double l = calculate(root.left);
        double r = calculate(root.right);
        double res = 0;
        if (root.val.equals("+")) {
            res = l + r;
        } else if (root.val.equals("-")) {
            res = l - r;
        } else if (root.val.equals("*")) {
            res = l * r;
        } else if (root.val.equals("/")) {
            res = l / r;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode("+");
        root.left = new TreeNode("*");
        root.right = new TreeNode("/");
        root.left.left = new TreeNode("-");
        root.left.right = new TreeNode("3");
        root.right.left = new TreeNode("4");
        root.right.right = new TreeNode("5");
        root.left.left.left = new TreeNode("2");
        root.left.left.right = new TreeNode("3");

        double v = calculate(root);
        System.out.println(v);
    }
}
