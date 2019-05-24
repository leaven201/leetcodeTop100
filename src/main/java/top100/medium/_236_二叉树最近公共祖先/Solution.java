package top100.medium._236_二叉树最近公共祖先;

import top100.model.TreeNode;

/**
 * @author LinZebin
 * @date 2019-04-22 16:06
 */
public class Solution {
    /** 方法1 */
    //前提条件：1.树中所有的值都不同 2.p、q的值不同且都存在与树中
    //递归的定义：在以root为根的树中找p、q的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归出口：root为null或者找到了p或q
        if (root == null || root == p || root == q) {
            return root;
        }
        //此时说明：root不是p或q，且不为空，所以p、q一定存在于root的子树中
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //在左子树和右子树中各找到一个
        if (left != null && right != null) {
            return root;
        }
        //left==null 说明左子树中不存在p、q，所以去右子树中找公共祖先
        if (left == null) {
            return right;
        }
        //right==null 说明右子树中不存在p、q，所以去左子树中找公共祖先
        return left;
    }
    /** 方法2*/
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        ResultType rt = helper(root, p, q);
        if(rt.exist_p && rt.exist_q){
            return rt.node;
        }
        return null;
    }
    private ResultType helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return new ResultType(false, false, null);
        }
        //Divide
        ResultType left = helper(root.left, p, q);
        ResultType right = helper(root.right, p, q);
        //Conquer
        boolean exist_p = (left.exist_p || right.exist_p || root == p);
        boolean exist_q = (left.exist_q || right.exist_q || root == q);
        //如果root是P或者q 则如果LCA存在就一定是该root
        if(root == p || root == q){
            return new ResultType(exist_p, exist_q, root);
        }
        //左右子树均存在p或q节点
        if(left.node != null && right.node != null){
            return new ResultType(exist_p, exist_q, root);
        }
        //自由左子树存在p或者q
        if(left.node != null){
            return new ResultType(exist_p, exist_q, left.node);
        }
        if(right.node != null){
            return new ResultType(exist_p, exist_q, right.node);
        }
        return new ResultType(exist_p, exist_q, null);
    }
}
//由于不确定树是否含有p、q节点，因此需要添加判断条件
class ResultType{
    public boolean exist_p,exist_q;
    public TreeNode node;
    ResultType(boolean exist_p, boolean exist_q, TreeNode node){
        this.exist_p = exist_p;
        this.exist_q = exist_q;
        this.node = node;
    }
}
