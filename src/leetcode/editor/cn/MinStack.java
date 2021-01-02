package leetcode.editor.cn;

import java.util.Stack;

//Java：最小栈
//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    /** initialize your data structure here. */
    private Stack<Node> stack;
    class Node {
        // 数值
        int value;
        // 最小值
        Integer min;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Integer getMin() {
            return min;
        }

        public void setMin(Integer min) {
            this.min = min;
        }
    }

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int x) {
        Node node = new Node();
        node.setValue(x);
        if (stack.isEmpty()) {
            node.setMin(x);
        } else {
            Node peek = stack.peek();
            node.setMin(x>peek.min?peek.min:x);
        }
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public Integer top() {
        if (stack.isEmpty()){
            return null;
        }else {
            return stack.peek().value;
        }
    }

    public Integer getMin() {
        if (stack.isEmpty()){
            return null;
        }else {
            return stack.peek().min;
        }
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 在此处写入代码
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == popped[j]) { // 循环判断与出栈
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
