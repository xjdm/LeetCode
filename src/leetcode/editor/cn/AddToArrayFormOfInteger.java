package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：数组形式的整数加法
public class AddToArrayFormOfInteger{
    public static void main(String[] args) {
        P989Solution solution = new P989Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class P989Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> res = new LinkedList<>();
        for(int i = A.length-1 ; i >= 0 || K > 0 ; i--){
            if(i >= 0)
                K += A[i];
            res.addFirst(K % 10);
            K = K/10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
