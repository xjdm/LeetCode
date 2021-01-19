package com.idstaa.lg.stage8;

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
public class MaxSubString {
    public static void main(String[] args) {
        int aavvcdfacdrqw = new MaxSubString().lengthOfLongestSubstringTwoDistinct("yunarnaybrgwctnzqjoermfbbdczhjqloalzgtocgzbyksepzakvbqlyydytndkgiicxajfcsjhywhiaskftxalqnztnftakknjupjxkldtwpwowklaluuaohgdikxjshzfbmwtbljlfrquenkqdncsywvrjyqaghkfdesjjrhkrhdzchpmlwnlsteilwrjmoediprnwaiyykcnegapjcvrlwberxldfznuavdzpbbnmiziftlndcpimwkjtnpubuhhuwwgzguxfvvygeefxcmvvrekhfxlex");
        System.out.println(aavvcdfacdrqw);
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] chars = s.toCharArray();
        int res = 0, left = 0, right = 0, len = s.length();

        int[] arr = new int[2];
        int[] numArr = new int[128];
        int firstNumFirstPos = -1;
        int secondNumFirstPos = -1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        while (right < len) {
            int c = chars[right];
            if (arr[0] == -1) {
                arr[0] = c;
                numArr[c] = right;
                firstNumFirstPos = right;
            } else if (arr[1] == -1 && c != arr[0]) {
                arr[1] = c;
                numArr[c] = right;
                secondNumFirstPos = right;
            } else {
                if (c != arr[0] && c != arr[1]) { // 是个新元素，更新a[0],a[1]
                    if (numArr[arr[0]] < numArr[arr[1]]) { // 交换a[1]为a[0]
                        numArr[arr[0]] = -1;
                        arr[0] = arr[1];
                        firstNumFirstPos = secondNumFirstPos;
                        secondNumFirstPos = right;
                    }else {// 更新a[0]元素第一次出现的位置
                        firstNumFirstPos = numArr[arr[0]];
                        secondNumFirstPos = right;
                    }
                    arr[1] = c;
                }
                numArr[c] = right;
            }
            left = firstNumFirstPos;
            res = (right - left + 1) > res ? right - left + 1 : res;
            right++;
        }
        return res;

    }
}
