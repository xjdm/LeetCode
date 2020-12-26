package leetcode.editor.cn;
//Java：两整数之和
public class SumOfTwoIntegers{
    public static void main(String[] args) {
        P371Solution solution = new P371Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class P371Solution {
    public int getSum(int a, int b) {
        while(b!=0){
            int sum = a^b;
            b = (a&b)<<1;
            a = sum;
        }
        return  a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
