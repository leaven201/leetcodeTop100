package 剑指offers.用两个栈实现队列;

import java.util.Stack;

/**
 * @author LinZebin
 * @date 2019-10-03 15:13
 */
public class MyQueue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (empty()) {
            return -1;
        }
        // 如果stack2为空，则将stack1的所有元素弹入stack2，并弹出stack2栈顶元素
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (empty()) {
            return -1;
        }
        // 如果stack2为空，则将stack1的所有元素弹入stack2，并返回stack2栈顶元素
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    private boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
