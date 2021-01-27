package com.idstaa.lg.model1.stage1;


/**
 * 4/4 有效数字
 * 验证给定的字符串是否可以解释为十进制数字。
 *
 * 例如:
 *
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3 " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 *
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 *
 * 数字： 0-9
 * 指数："e"
 * 正/负号： "+" "-"
 * 小数点： "."
 * 当然，在输入中，这些字符的上下文也很重要。
 */
public class Solution4 {
    public boolean isNumber(String s) {
        int pointNum = 0;
        int ePointNum = 0;
        // 去掉首尾空格；
        char[] chars = s.trim().toCharArray();
        if (chars[0] == '-' || chars[0] == '+'|| chars[0] >= '0' && chars[0] <= '9' || chars[0] == '.') {
            if(chars[0] == '.'){
                ePointNum++;
            }
            for (int i = 1; i < chars.length; i++) {
                char aChar = chars[i];
                if (chars[i] >= '0' && chars[i] <= '9') {
                    continue;
                } else if (aChar == '.') {
                    pointNum++;
                    // 小数点不能再最后，4不能有多个，且不能再e的后面
                    if (i == chars.length-1 || pointNum > 1 || ePointNum >= 1) {
                        return false;
                    }
                } else if (aChar == 'E'||aChar == 'e') {
                    ePointNum++;
                    // e不能在最后，不能有多个
                    if (i == chars.length-1 || ePointNum > 1) {
                        return false;
                    }
                }else if(chars[i] == '-' || chars[i] == '+'){
                    // -,+ 的前后必须带E 且不是最后一位
                    if((chars[i-1] != 'E' && chars[i-1] !='e') || i == chars.length-1){
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution4().isNumber(".1"));
    }
}
