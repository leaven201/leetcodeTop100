package top100.model;

public class TreeNode {
    public int val;
    public TreeNode left, right, father;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = this.father = null;
    }
}
