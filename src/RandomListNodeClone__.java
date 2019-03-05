/**
 * created by Zheng Jiateng on 2019/3/5.
 */

import base.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制 : 不能给任何一点赋原链表的任一结点的引用 用辅助空间 一个Map 来存储原结点和新建结点的映射关系
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

public class RandomListNodeClone__ {
    public RandomListNode clone(RandomListNode pHead) {
        RandomListNode iter = new RandomListNode(-1);
        RandomListNode p = pHead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (p != null) {
            RandomListNode temp = new RandomListNode(p.label);
            map.put(p, temp);
            p = p.next;
            iter.next = temp;
            iter = temp; // iter保存的是上一个node
        }
        for (Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet()) {
            entry.getValue().random = map.get(entry.getKey().random);
        }
        return map.get(pHead);
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
