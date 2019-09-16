package 剑指offers.二叉搜索树的后序遍历序列;

/**
 * @author LinZebin
 * @date 2019-05-19 18:58
 */
public class Solution {

    public boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return true;
        }
        return helper(sequence, 0, sequence.length - 1);
    }

    // 判断sequence中从start开始到end结束的序列是否是二叉搜索树的后序遍历结果
    private boolean helper(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = sequence[end];
        //index：左右子树的分界
        int index = end;
        for (int i = start; i < end; i++) {
            if (sequence[i] > root) {
                index = i;
                break;
            }
        }
        for (int i = index; i < end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        boolean left = helper(sequence, start, index - 1);
        boolean right = helper(sequence, index, end - 1);
        return left && right;
    }


    public static void main(String[] args) {
        int[] sequence = {1, 2, 5, 4, 9, 10, 7, 3, 6, 8};
        Solution s = new Solution();
        final boolean b = s.verifySequenceOfBST(sequence);
        System.out.println(b);
    }
}
