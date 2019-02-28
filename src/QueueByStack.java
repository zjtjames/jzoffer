/**
 * created by Zheng Jiateng on 2019/2/27.
 */

import java.util.Stack;

/**
 * 用两个栈实现队列：pop()时，要先从stack2取，直到取空，若stack2为空，才把stack1的元素一次性装入stack2
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class QueueByStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.empty()) {
            return stack2.pop();
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
