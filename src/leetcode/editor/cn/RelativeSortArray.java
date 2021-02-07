package leetcode.editor.cn;

import java.util.*;

//Java：数组的相对排序
public class RelativeSortArray {
    public static void main(String[] args) {
        Solution1122 solution = new Solution1122();
        int arr1[] = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19, 5}, arr2[] = {2, 1, 4, 3, 9, 6};
        // TO TEST
        solution.relativeSortArray(arr1, arr2);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] tmp=new int [1001];
        for(int num:arr1){
            tmp[num]++;
        }
        int pos=0;      //arr1中索引的位置 也是arr2中含有的数字在arr1中的最大长度
        for(int num:arr2){
            while(tmp[num]>0){
                arr1[pos++]=num;
                tmp[num]--;
            }
        }
        //int check=pos;  这里是arr2中没有的值开始的位置。
        for(int i=0;i<1001;++i){
            while(tmp[i]>0){
                arr1[pos++]=i;
                tmp[i]--;
            }
        }
        return arr1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
