package leetcode.editor.cn;

import com.idstaa.lg.stage1.Solution1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//Java：翻转字符串里的单词
public class ReverseWordsInAString {
    public static void main(String[] args) {
        Solution186 solution = new Solution186();
        // TO TEST
        String s = solution.reverseWords(" the sky   is   blue ");
        System.out.println(s);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution186 {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <str.length; i++) {
            if (str[i].length() != 0) {
                char[] chars = str[i].toCharArray();
                reverse(chars,0,chars.length-1);
                sb.append(" ").append(chars);
            }
        }
        return sb.substring(1);
    }

    public void reverse(char[] s, int start, int end) {
        while (start < end) {//如果起始索引小于终止索引，进行反转
            //交换双指针对应的字符
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
