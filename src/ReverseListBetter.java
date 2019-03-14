/**
 * created by Zheng Jiateng on 2019/3/14.
 */

import base.*;


/**
 * 反转链表：上一个类是笨办法 用了太多的辅助空间 这里是更好的办法 用三个指针 分别指向当前遍历到的节点、它的前一个节点以及后一个节点
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 * a->b->c->d->null
 * null<-a<-b<-c<-d
 */
public class ReverseListBetter {
    public ListNode reverseList(ListNode head) {
        ListNode reversedHead = null;
        ListNode node = head;
        ListNode previous = null;
        while (node != null) {
            if (node.next == null) {
                reversedHead = node;
            }
            ListNode next = node.next;
            node.next = previous;
            previous = node;
            node = next;
        }
        return reversedHead;
    }
}