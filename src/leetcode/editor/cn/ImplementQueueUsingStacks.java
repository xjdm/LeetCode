package leetcode.editor.cn;

import java.util.Stack;

//Java：用栈实现队列
public class ImplementQueueUsingStacks{
    public static void main(String[] args) {
        /*Solution solution = new Solution();*/
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class MyQueue {
    private Stack<Integer> stackA ;
    private Stack<Integer> stackB ;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.stackA = new Stack();
        this.stackB = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!stackB.isEmpty()){
            stackA.push(stackB.pop());
        }
        stackA.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
        return stackB.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        while(!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
        return stackB.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stackA.isEmpty()&&stackB.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)
