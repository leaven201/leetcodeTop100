package top100.easy.最小栈155;

import java.util.Stack;

/**
 * @author LinZebin
 * @date 2019-09-25 14:57
 */
public class MinStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MinStack() {
    }

    public void push(int x) {
        this.stack1.push(x);
        if(stack2.isEmpty()){
            stack2.push(x);
        }else{
            stack2.push(Math.min(x,stack2.peek()));
        }
    }

    public void pop() {
        this.stack1.pop();
        this.stack2.pop();
    }

    public int top() {
        return this.stack1.peek();
    }

    public int getMin() {
        return this.stack2.peek();
    }
}
