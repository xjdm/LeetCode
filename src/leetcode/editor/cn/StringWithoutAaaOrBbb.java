package leetcode.editor.cn;

//Java：不含 AAA 或 BBB 的字符串
public class StringWithoutAaaOrBbb {
    public static void main(String[] args) {
        Solution_984 solution = new Solution_984();
        // TO TEST
        String s = solution.strWithout3a3b(1, 3);
        System.out.println(s);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_984 {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        // a>b  打印aab
        // a==b 打印ab

        // a<b  打印bba
        // a=b 打印ba

        while (a > 0 && b > 0) {
            if (a > b) {
                sb.append("aab");
                a = a - 2;
                b--;
            } else if (b > a) {
                sb.append("bba");
                a--;
                b = b - 2;
            } else if (a == b) {
                sb.append("ba");
                a--;
                b--;
            }
        }

        while(a>0){
            sb.append("a");
            a--;
        }
        while(b>0){
            sb.append("b");
            b--;
        }

        return sb.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
