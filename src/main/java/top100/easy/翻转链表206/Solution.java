package top100.easy.翻转链表206;

import top100.model.ListNode;

/**
 * @author LinZebin
 * @date 2019-09-19 20:15
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        while(head != null){
            ListNode nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
        return preNode;
    }
}
