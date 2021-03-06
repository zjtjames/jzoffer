/**
 * Created by Zheng Jiateng on 2019/3/15.
 */

import base.ListNode;

/**
 * 链表中环的入口结点: 空间复杂度O(1)解法 用两个指针 一个一次走一步 一个一次都两步
 */
public class EntryNodeOfLoopBetter {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode node1 = pHead;
        ListNode node2 = pHead;
        node1 = node1.next;
        node2 = node2.next.next;
        while (node1 != node2) { // 追上的时候 快的把慢的套圈了 快的走了2x 慢的走了x 2x-x = kn n为环的节点数
            node1 = node1.next;
            node2 = node2.next.next;
        }
        // 假设直线长y 则让node2从头开始走 走到环入口时 node1共走了kn+y 刚好也到环入口
        node2 = pHead;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
}
