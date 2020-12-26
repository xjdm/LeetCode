package leetcode.editor.cn;

//Java：二进制求和
public class AddBinary {
    public static void main(String[] args) {
        P67Solution solution = new P67Solution();
        // TO TEST
        String s = solution.addBinary("1", "1000");
        System.out.println(s);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class P67Solution {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        for (int i = a.length()-1,j=b.length()-1; i >= 0 || j>=0; i--,j--) {
            int sum = carry;
            if(i>=0) {
                sum += a.charAt(i) - '0';
            }
            if (j>=0) {
                sum += b.charAt(j) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if(carry==1){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
