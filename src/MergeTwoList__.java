/**
 * created by Zheng Jiateng on 2019/2/27.
 */
import base.*;
/**
 * 合并两个排序的链表 ：注意一开始存表头
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeTwoList__ {

    public ListNode merge(ListNode list1,ListNode list2) {
        // 用head把头存储起来
        ListNode head;
        // list3迭代覆盖
        ListNode list3 = new ListNode(0);
        head = list3;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                list3.next = list1;
                list3 = list3.next;
                list1 = list1.next;
            } else {
                list3.next = list2;
                list3 = list3.next;
                list2 = list2.next;
            }
        }
        while (list1 != null && list2 == null) {
            list3.next = list1;
            list3 = list3.next;
            list1 = list1.next;

        }
        while (list1 == null && list2 != null) {
            list3.next = list2;
            list3 = list3.next;
            list2 = list2.next;
        }
        return head.next;
    }
}
