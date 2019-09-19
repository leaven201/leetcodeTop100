package top100.easy.合并两个有序链表21;

import top100.model.ListNode;

/**
 * @author LinZebin
 * @date 2019-09-19 20:34
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        dummy.next = node;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                node.next = l2;
                l2 = l2.next;
            }else{
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        while(l1 != null){
            node.next = l1;
            l1 = l1.next;
            node = node.next;
        }
        while(l2 != null){
            node.next = l2;
            l2 = l2.next;
            node = node.next;
        }
        return dummy.next;
    }
}
