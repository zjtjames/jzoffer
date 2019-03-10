/**
 * created by Zheng Jiateng on 2019/3/10.
 */

import base.ListNode;

/**
 * 两个链表的第一个公共结点 : 要点在于，从第一个公共结点开始，后面两个链表都是相同的，重叠的
 * 对于不同长度的链表，把长的截到跟短的一样短，然后一起往后走
 *
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode__ {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0;
        int len2 = 0;
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (node1 != null) {
            len1++;
            node1 = node1.next;
        }
        while (node2 != null) {
            len2++;
            node2 = node2.next;
        }
        int gap = Math.abs(len1 - len2);
        if (len1 > len2) {
            for (int i = 0; i < gap; i++) {
                pHead1 = pHead1.next;
            }
        } else if (len1 < len2) {
            for (int i = 0; i < gap; i++) {
                pHead2 = pHead2.next;
            }
        }
        node1 = pHead1;
        node2 = pHead2;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
}
