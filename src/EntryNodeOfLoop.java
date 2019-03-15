/**
 * Created by Zheng Jiateng on 2019/3/15.
 */

import base.ListNode;

import java.util.ArrayList;

/**
 * 链表中环的入口结点:
 *
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        ArrayList<ListNode> listNodes = new ArrayList<>();
        ListNode listNode = pHead;
        while (listNode != null) {
            if (listNodes.contains(listNode)) {
                return listNode;
            }
            listNodes.add(listNode);
            listNode = listNode.next;
        }
        return null;
    }
}
