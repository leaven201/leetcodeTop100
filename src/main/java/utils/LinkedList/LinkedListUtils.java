package utils.LinkedList;

import top100.model.ListNode;

/**
 * @author LinZebin
 * @date 2019-04-28 22:02
 */
public class LinkedListUtils {

    public static void printList(ListNode node){
        while (node != null){
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.println();
    }
}
