package com.idstaa.lg.model1.stage4;

import java.util.Stack;

/**
 * @author chenjie
 * @date 2021/1/2 22:43
 */
public class CQueue {
    private Stack<Integer> stackA ;
    private Stack<Integer> stackB ;
    public CQueue() {
        this.stackA = new Stack();
        this.stackB = new Stack();
    }

    public void appendTail(int value) {
        //在此处写入代码
        while(!stackB.isEmpty()){
            stackA.push(stackB.pop());
        }
        stackA.push(value);
    }

    public int deleteHead() {
        while(!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
        if(stackB.isEmpty()){
            return -1;
        }
        return stackB.pop();
    }
}
