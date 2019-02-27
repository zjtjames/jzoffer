/**
 * created by Zheng Jiateng on 2019/2/27.
 */


import java.util.ArrayList;

/**
 * 链表中倒数第k个节点 : 代码的鲁棒性
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode findKthToTail(ListNode head,int k) {
        if (head != null) {
            ArrayList<ListNode> list = new ArrayList<>();
            while (head.next != null) {
                list.add(head);
                head = head.next;
            }
            list.add(head);
            if (list.size() >= k && k > 0) {

                return list.get(list.size() - k);
            }
        }
        return null;
    }
}
