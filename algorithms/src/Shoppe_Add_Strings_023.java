/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *
 *
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 */

public class Shoppe_Add_Strings_023 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int temp = 0;
        StringBuilder s = new StringBuilder();
        while (i>=0 || j>=0 || temp>0){
            int first = i>=0?num1.charAt(i)-'0':0;
            int second = j>=0?num2.charAt(j)-'0':0;
            int val = first+second+temp;
            s.append(val%10);
            temp = val/10;
            i--;
            j--;
        }
        return s.reverse().toString();
    }
}
