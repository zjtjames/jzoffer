/**
 * Created by Zheng Jiateng on 2019/2/23.
 */

import java.util.ArrayList;

import base.*;
/**
 * 从尾到头打印链表：辅助空间ArrayList
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
 */
public class PrintListFromTailToHead {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        // 注意要先判断listNode是否为null 因为是null的话不能add到ArrayList中
        if (listNode == null) {
            return arrayList1;
        }
        while (listNode.next != null) {
            arrayList1.add(listNode.val);
            listNode = listNode.next;
        }
        arrayList1.add(listNode.val);
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i = arrayList1.size() -1; i >=0; i--) {
            arrayList2.add(arrayList1.get(i));
        }
        return arrayList2;
    }



}
