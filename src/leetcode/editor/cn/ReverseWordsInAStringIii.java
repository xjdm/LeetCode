package leetcode.editor.cn;
//Java：反转字符串中的单词 III
public class ReverseWordsInAStringIii{
    public static void main(String[] args) {
        Solution557 solution = new Solution557();
        // TO TEST
        String s = solution.reverseWords(" the sky   is   blue ");
        System.out.println(s);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution557 {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = str.length-1; i>=0; i--) {
            if (str[i].length() != 0) {
                char[] chars = str[i].toCharArray();
                reverse(chars,0,chars.length-1);
                sb.append(" ").append(str[i]);
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
