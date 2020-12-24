package com.idstaa.lg.stage1;

/**
 * @author chenjie
 * @date 2020/12/24 11:17
 */
public class Solution {
    public int myAtoi(String str) {
        // 在此处写入代码
        char[] chars = str.toCharArray();
        int result =0;
        for (int i = 0; i < chars.length; i++) {
            result = result*10+(chars[i]-'0');
        }
        return result;
    }

    public static void main(String[] args) {
        int i = new Solution().myAtoi("4231111111111");
        System.out.println(i);
    }
}
