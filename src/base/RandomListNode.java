/**
 * created by Zheng Jiateng on 2019/3/5.
 */
package base;

/**
 * 复杂链表的数据结构
 * 每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点
 */
public class RandomListNode {
    public int label;
    public RandomListNode next = null;
    public RandomListNode random = null;

    public RandomListNode(int label) {
        this.label = label;
    }
}
