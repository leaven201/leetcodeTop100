package top100.easy._206_ReverseLinkedList;

import org.junit.Test;
import top100.utils.ListNode;
import utils.LinkedList.LinkedListUtils;

/**
 * @author LinZebin
 * @date 2019-04-28 21:53
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        // preNode一定要初始化为null，反转后首节点的下一节点是null
        ListNode preNode = null;
        while (head != null){
            ListNode nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
        return preNode;
    }

    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        ListNode reverseList = reverseList(node1);
        LinkedListUtils.printList(reverseList);
    }

}
