/**
 * created by Zheng Jiateng on 2019/2/27.
 */

import java.util.ArrayList;

/**
 * 反转链表：输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        while (head.next != null) {
            list.add(head);
            head = head.next;
        }
        list.add(head);
        head = list.get(list.size() - 1);
        for (int i = list.size() - 2; i >= 0; i--) {
            ListNode listNode = list.get(i + 1);
            listNode.next = list.get(i);
        }
        ListNode listNode = list.get(0);
        listNode.next = null;
        return head;
    }
}
