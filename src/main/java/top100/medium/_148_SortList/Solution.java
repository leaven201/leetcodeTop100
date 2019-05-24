package top100.medium._148_SortList;

import org.junit.Test;
import top100.model.ListNode;

/**
 * @author LinZebin
 * @date 2019-04-15 22:04
 */
public class Solution {

    //将链表head排序，返回第一个节点
    public ListNode sortList(ListNode head) {
        // 递归出口，当链表只有一个节点时，说明已经排好序
        if (head == null || head.next == null) {
            return head;
        }
        // 将一个链表拆成相等的两段并排序
        // 拆分1-2-3-4-5-null为 front : 1-2-null last: 3-4-5-null
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //此时fast到尾，slow为第二段的第一个，pre为第一段的最后一个
        pre.next = null;
        ListNode front = sortList(head);
        ListNode last = sortList(slow);
        // 合并两个排序的链表，返回第一个节点
        return merge(front, last);

    }

    // 合并两个有序的链表，并返回第一个节点
    private ListNode merge(ListNode front, ListNode last) {
        ListNode dummy = new ListNode(0);
        ListNode curt = dummy;

        while (front != null && last != null) {
            if (front.val > last.val) {
                curt.next = last;
                last = last.next;
            } else {
                curt.next = front;
                front = front.next;
            }
            curt = curt.next;
        }
        while (front != null) {
            curt.next = front;
            curt = curt.next;
            front = front.next;
        }
        while (last != null) {
            curt.next = last;
            curt = curt.next;
            last = last.next;
        }
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode sort = sortList(node1);
        while (sort != null) {
            System.out.print(sort.val + " ");
            sort = sort.next;
        }
    }

}
