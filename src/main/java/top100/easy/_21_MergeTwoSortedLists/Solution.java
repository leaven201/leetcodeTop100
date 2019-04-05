package top100.easy._21_MergeTwoSortedLists;

import top100.utils.ListNode;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode curt = dummy;
        dummy.next = curt;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curt.next = l1;
                l1 = l1.next;
                curt = curt.next;
            } else {
                curt.next = l2;
                l2 = l2.next;
                curt = curt.next;
            }
        }
        while (l1 != null) {
            curt.next = l1;
            curt = curt.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            curt.next = l2;
            curt = curt.next;
            l2 = l2.next;
        }
        return dummy.next;
    }
}
