/**
 * created by Zheng Jiateng on 2019/2/28.
 */

import java.util.Stack;
/**
 * 包含min函数的栈 : 关键是在栈pop()出一些值后仍能正确的给出最小元素，所以不能简单的存一个int值表示min,
 *                  额外用一个栈保存最小值，多个最小值都存
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class MinStack__ {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();

    public void push(int node) {
        stack1.push(node);
        if (stackMin.isEmpty()) {
            stackMin.push(node);
        } else if (node <= stackMin.peek()) {
            stackMin.push(node);
        }
    }

    public void pop() {
        if (stack1.peek() == stackMin.peek()) {
            stackMin.pop();
        }
        stack1.pop();

    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stackMin.peek();
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        System.out.println(stack1.pop());

    }
}
