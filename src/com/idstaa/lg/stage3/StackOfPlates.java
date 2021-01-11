package com.idstaa.lg.stage3;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author chenjie
 * @date 2020/12/29 11:03
 */
public class StackOfPlates {
    private ArrayList<Stack<Integer>> stackList;
    private Integer cap;

    class Node{
        int stackNum;
        int stackDataCount;

        public Node(int stackNum, int stackDataCount) {
            this.stackNum = stackNum;
            this.stackDataCount = stackDataCount;
        }
    }

    public StackOfPlates(int cap) {
        // 在此处写入代码
        stackList = new ArrayList<>();
        this.cap = cap;
    }

    public void push(int val) {
        // 在此处写入代码

    }

    public Integer pop() {
        // 在此处写入代码
        return  1;
    }

    public int popAt(int index) {
        // 在此处写入代码
        return  1;
    }

    public static void main(String[] args) {
        StackOfPlates obj = new StackOfPlates(2);
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.popAt(1);
    }
}
