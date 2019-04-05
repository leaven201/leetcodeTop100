package top100.easy._20_ValidParentheses;

import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        //长度为奇数，肯定unvalid
        if ((s.length() & 1) == 1) {
            return false;
        }
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            outstack(stack, s.charAt(i));
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    private void outstack(Stack<Character> stack, char ch) {
        //栈为空，则入栈
        if (stack.isEmpty()) {
            stack.add(ch);
        } else if (valid(stack.peek(), ch)) {//ch与栈顶匹配，则出栈
            stack.pop();
        } else {//不匹配，入栈
            stack.add(ch);
        }
    }

    private boolean valid(char ch1, char ch2) {
        if (ch1 == '{' && ch2 == '}') {
            return true;
        } else if (ch1 == '(' && ch2 == ')') {
            return true;
        } else if (ch1 == '[' && ch2 == ']') {
            return true;
        }
        return false;
    }
}
