package 剑指offers.从尾到头打印链表;

import top100.model.ListNode;

import java.util.Stack;

/**
 * @author LinZebin
 * @date 2019-09-30 18:49
 */
public class Solution {
    public int[] printListReversingly(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

}
