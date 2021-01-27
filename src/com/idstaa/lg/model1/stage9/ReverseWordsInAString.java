package com.idstaa.lg.model1.stage9;

//Java：翻转字符串里的单词
public class ReverseWordsInAString {
    public static void main(String[] args) {
        Solution186 solution = new Solution186();
        // TO TEST
        solution.reverseWords(" the sky   is   blue ".toCharArray());
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution186 {
    public void reverseWords(char[] s) {
        int start = 0,end = s.length-1;
        reverseWords(s,start,end);
        for (int i=0;i<s.length;i++){
            if(s[i]==' ') {
                end = i-1;
                reverseWords(s,start,end);
                start = i+1;
            }
        }
        reverseWords(s,start,s.length-1);

    }

    public void reverseWords(char[] s,int start,int end){
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
