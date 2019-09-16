package top100.medium.寻找环的入口;

import top100.model.ListNode;

/**
 * @author LinZebin
 * @date 2019-07-05 21:19
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }

}