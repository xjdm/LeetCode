package leetcode.editor.cn;

//Java：字符串转换整数 (atoi)
public class StringToIntegerAtoi {
    public static void main(String[] args) {
        P8Solution solution = new P8Solution();
        // TO TEST
        int i = solution.myAtoi(" ");
        System.out.println(i);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class P8Solution {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        if(chars.length==0){
            return 0;
        }
        int sign = 1;
        int firstBlankCount = 0;
        int haveSign = 0;
        // 统计空格的个数
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                firstBlankCount++;
            } else {
                break;
            }
        }
        int result = 0;
        long longResult = 0;
        boolean haveNumber = false;
        for (int i = firstBlankCount; i < chars.length; i++) {
            if (haveSign==0 && (chars[firstBlankCount] == '-' || chars[firstBlankCount] == '+')) {
                haveSign = 1;
                sign = chars[firstBlankCount] == '-' ? -1 : 1;
                continue;
            }
            if (chars[i] >= '0' && chars[i] <= '9') {
                longResult = longResult * 10 + (chars[i] - '0');
                if (longResult > Integer.MAX_VALUE) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MAX_VALUE * sign - 1;
                } else if (longResult < Integer.MIN_VALUE) {
                    return sign == 1 ? Integer.MIN_VALUE : Integer.MIN_VALUE * sign;
                }
            } else {
                break;
            }
            haveNumber = true;
        }
        result = (int) longResult;
        if (sign != 0) {
            result *= sign;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
