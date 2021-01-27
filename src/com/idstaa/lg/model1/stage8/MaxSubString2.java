package com.idstaa.lg.model1.stage8;

/**
 * 2/4 至多包含两个不同字符的最长子串
 * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "eceba"
 * 输出: 3
 * 解释: t 是 "ece"，长度为3。
 * 示例 2:
 * <p>
 * 输入: "ccaabbb"
 * 输出: 5
 * 解释: t 是 "aabbb"，长度为5。
 *
 * @author chenjie
 * @date 2021/1/19 0:50
 */
public class MaxSubString2 {
    public static void main(String[] args) {
        int aavvcdfacdrqw = new MaxSubString2().lengthOfLongestSubstringTwoDistinct("eceba", 2);
        System.out.println(aavvcdfacdrqw);
    }

    public int lengthOfLongestSubstringTwoDistinct(String s, int k) {
        char[] chars = s.toCharArray();
        int res = 0, left = 0, right = 0, len = 0;
        int[] map = new int[128];
        int count = 0;
        while (right < chars.length) {
            int c = chars[right];
            if (++map[c] == 1) {
                count++;
            }
            while (count > k) {
                int removeChar = chars[left++];
                if (--map[removeChar] == 0) {
                    count--;
                }
            }
            res = (right - left + 1) > res ? (right - left + 1) : res;
            right++;
        }
        return res;

    }
}
