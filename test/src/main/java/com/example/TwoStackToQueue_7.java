package com.example;

import java.util.Stack;

/**
 * Created by yifeng on 15/12/3.
 */
public class TwoStackToQueue_7 {

    /**
     * 1. 描述
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。队列中的元素为int类型。
     *
     * 2. 思路
     * stack1 用来存入数据,
     * 当需要删除数据生活, 把stack1中数据依次弹出进 stack2, 删除栈顶. 如果stack2中有数据,直接弹栈
     **/
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
