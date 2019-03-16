/**
 * created by Zheng Jiateng on 2019/3/16.
 */

import base.ListNode;

/**
 * 删除链表中重复的结点: 如果是11112 pHead也要被删除 所以要设置一个newHead 解决头删不掉的问题
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        int value = pHead.val - 1;
        ListNode newHead = new ListNode(value);
        newHead.next = pHead;
        ListNode node = newHead;
        ListNode previous = newHead;
        while (node!= null) {
            if (node.next != null && node.next.val == node.val) {
                value = node.val;
            }
            if (node.val == value) {
                node = node.next;
                previous.next = node;
            } else {
                previous = node;
                node = node.next;
            }
        }
        return newHead.next;
    }
}
