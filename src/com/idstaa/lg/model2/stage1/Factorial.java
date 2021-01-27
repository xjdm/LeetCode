package com.idstaa.lg.model2.stage1;

/**
 * @author chenjie
 * @date 2021/1/27 11:34
 *
 * 1/4 数字阶乘的计算
 * 求 n!=(n-1)!×n
 *
 * 示例：
 * 输入：n=9
 * 输出：362880
 *
 * 提示：
 * 0！=1
 * 给“0！”下定义只是为了相关公式的表述及运算更方便
 *
 * n为大于等于0的整数
 */
public class Factorial {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int fact = solution.fact(4);
        System.out.println(fact);
    }

    static class Solution {
        public int fact(int n){
            if(n==0 || n==1) {
                return 1;
            }
            return n*fact(n-1);
        }
    }
}
