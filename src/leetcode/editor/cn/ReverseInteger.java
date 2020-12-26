package leetcode.editor.cn;

//Java：整数反转
public class ReverseInteger {
    public static void main(String[] args) {
        P7Solution solution = new P7Solution();
        // TO TEST
        int reverse = solution.reverse(1000);
        System.out.println(reverse);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class P7Solution {
    public int reverse(int x) {
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
            return 0;
        }
        int sign = x > 0 ? 1 : -1;
        x = x < 0 ? x * -1 : x;
        int last = 0;// 末位
        int result = 0;
        while ((last = x % 10) != x) {
            result = result * 10 + last;
            x /= 10;
        }
        if (last != 0) {
            long re = result;// 越界处理
            re = re * 10 + last;
            if (re > Integer.MAX_VALUE || re < Integer.MIN_VALUE) {
                result = 0;
            } else {
                result = (int) re;
            }
        }

        return result * sign;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
